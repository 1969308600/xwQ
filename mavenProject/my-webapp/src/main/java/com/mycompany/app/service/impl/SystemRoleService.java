package com.mycompany.app.service.impl;

import java.util.List;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.system.ConnectRoleMenuBtn;
import org.mybatis.system.SystemRole;
import org.mybatis.system.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.web.test.Page;
import com.mycompany.app.service.SystemBaseServiceI;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class SystemRoleService implements SystemBaseServiceI<SystemRole> {
	
	@Autowired
	SqlSessionTemplate sql;

	@Override
	public SystemRole getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemRole> getEntityList(Page page) {
		return sql.selectList("getRoleList",page);
	}

	@Override
	public SystemRole findEntityByOneArg(String arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEntity(SystemRole t) {
		return sql.update("updateRole",t);
		
	}
	@Override
	@Transactional
	public int InsertEntity(SystemRole t) {
		return sql.insert("insertRole",t);
		
	}
	@Transactional
	public int updateRoleRelation(SystemRole t) {
		return sql.insert("insertRoleRelation",t);
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(isolation=Isolation.SERIALIZABLE) 
	public int updateRoleRelation(JSONObject jsono) {
	 
		//寮�鍚簲鍗佷釜绾跨▼
		ExecutorService ex = Executors.newFixedThreadPool(100);
		//璇诲啓閿�
		ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
		WriteLock wl = rwl.writeLock();
		ReadLock read = rwl.readLock();
		//浠巎son涓В鏋恗enu btn 
		String roleId =(String)jsono.get("roleId");
		
		//timer 
		
		for(Object o:jsono.keySet()) {
			JSONArray btnsStr = null;
			String menuKey = ((String)o).replace("id", "");
			try {
				wl.lock();//寮�鍚啓閿�
				if(!menuKey.equals("roleId")) {//灏嗕笉鐢ㄧ殑鎺掗櫎鎺夛紝涓嶇劧鎶ラ敊  JSONObject["idroleId"] is not a JSONArray.
					btnsStr = jsono.getJSONArray("id"+menuKey);
				}
			}finally {
				wl.unlock();//鍏抽棴鍐欓攣
			}
			try {
				//menuKey = menuKey;
				read.lock();//铏界劧鍔犱簡鍐欓攣锛屼絾鍦ㄨ鍙栨椂浼氬嚭鑴忓�硷紝鍔犱笂璇婚攣.
				if(btnsStr!=null&&btnsStr.size()>0) {
					btnsStr.forEach((str)->{
						ConnectRoleMenuBtn connect = new ConnectRoleMenuBtn(roleId,menuKey,str+"");
						ex.execute(new Runnable() {
							@Override
							public void run() {
								doRelation(connect);
							}
						});
					});
				}else {
					if(!menuKey.equals("roleId")) {
						ConnectRoleMenuBtn connect = new ConnectRoleMenuBtn(roleId,menuKey,"");
						ex.execute(new Runnable() {
							@Override
							public void run() {
								doRelation(connect);
							} 
						});
					}
				}
			}finally {
				read.unlock();//鍏抽棴鍐欓攣
			}
		}
		ex.shutdown();//for 瀹屼簡涔嬪悗 灏变笉鍐嶆帴鍙椾换鍔�
		int res = 0;
		if(ex.isTerminated()) {
			res = 1;
//			Timer timer = new Timer();
//			timer.schedule(new TimerTask() {
//				@Override
//				public void run() {
//					try {
//					Message ms = jms.receive("insertMenuBtnQuene"); 
//					String json = ms.toString();
//					TextMessage tm = (TextMessage)ms;
//					System.out.println(json);
//					System.out.println(tm.getText());
//					}catch(Exception e) {
//						timer.cancel();
//					}
//				}
//			}, 1000);
		}else {
			res = -1;
		}
		return res;
	}
	@Transactional(isolation=Isolation.SERIALIZABLE) 
	public void doRelation(ConnectRoleMenuBtn t) {
		//sql.insert("insertRoleRelation",t);
		//鎻掑叆mq
//		jms.send("insertMenuBtnQuene", new MessageCreator() {
//			public Message createMessage(Session session) throws JMSException {
//			    return session.createTextMessage(JSONObject.fromObject(t).toString());
//			}
//        });
	}
	
	 

}
