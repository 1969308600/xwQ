package com.mycompany.app.common;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.core.util.Assert;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.mycompany.app.entity.CacheEntity;

@Component
public class CacheRedisCommon  implements Serializable{
	
	 
	private  static final long serialVersionUID = 1L;
	
	@Resource
	RedisTemplate<String,CacheEntity> redisTemplate;
	public void test() {
	}
	  /**
     * ��Ӷ���
     */
    public boolean add(final CacheEntity member) { 
    	
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                byte[] key  = serializer.serialize(member.getId());  
                byte[] name = serializer.serialize(member.getValue());  
                return connection.setNX(key, name);  
            }  
        });  
        return result;  
    }  

    /**
     * ��Ӽ���
     */
    public boolean add(final List<CacheEntity> list) {
        Assert.isNonEmpty(list);  
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                for (CacheEntity member : list) {  
                    byte[] key  = serializer.serialize(member.getId());  
                    byte[] name = serializer.serialize(member.getValue());  
                    connection.setNX(key, name);  
                }  
                return true;  
            }  
        }, false, true);  
        return result; 
    }  
    
    /**
     * ɾ������ ,����key
     */
    public void delete(String key) {  
        List<String> list = new ArrayList<String>();  
        list.add(key);  
        delete(list);
        
    }  
  
    /**
     * ɾ������ ,����key����
     */
    public void delete(List<String> keys) {  
        redisTemplate.delete(keys);  
    }  
    
    /**
     * �޸Ķ��� 
     */
    public boolean update(final CacheEntity member) {  
        String key = member.getId();  
        if (get(key) == null) {  
            throw new NullPointerException("�����в�����, key = " + key);  
        }  
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                byte[] key  = serializer.serialize(member.getId());  
                byte[] name = serializer.serialize(member.getValue());  
                connection.set(key, name);  
                return true;  
            }  
        });  
        return result;  
    }  
    
    /**
     * ����key��ȡ����
     */
    public CacheEntity get(final String keyId) {  
    	CacheEntity result = redisTemplate.execute(new RedisCallback<CacheEntity>() {  
            public CacheEntity doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                byte[] key = serializer.serialize(keyId);  
                byte[] value = connection.get(key);  
                if (value == null) {  
                    return null;  
                }  
                String nickname = serializer.deserialize(value);  
                return new CacheEntity(keyId, nickname);  
            }  
        });  
        return result;  
    }  
}
