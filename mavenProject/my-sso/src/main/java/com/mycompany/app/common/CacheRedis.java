package com.mycompany.app.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
public class CacheRedis  implements Serializable{
	
	 
	private static final long serialVersionUID = 1L;
	
	@Resource
	RedisTemplate<String,CacheEntity> redisTemplate;
	public void test() {
	}
	  /**
     * 添加对象
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
     * 设置时间
     */
    public boolean keyTimeOut(String key,int  timeOut ) { 
    	
    	boolean result = redisTemplate.expire(key,timeOut, TimeUnit.SECONDS); 
    	return result;  
    }  

    /**
     * 添加集合
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
     * 删除对象 ,依赖key
     */
    public void delete(String key) {  
        List<String> list = new ArrayList<String>();  
        list.add(key);  
        delete(list);  
    }  
  
    /**
     * 删除集合 ,依赖key集合
     */
    public void delete(List<String> keys) {  
        redisTemplate.delete(keys);  
    }  
    
    /**
     * 修改对象 
     */
    public boolean update(final CacheEntity member) {  
        String key = member.getId();  
        if (get(key) == null) {  
            throw new NullPointerException("数据行不存在, key = " + key);  
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
     * 根据key获取对象
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
