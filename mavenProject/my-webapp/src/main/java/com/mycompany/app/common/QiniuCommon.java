package com.mycompany.app.common;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public  class QiniuCommon extends StaticField{

	
	/**
	 *  验签  生成上传时的令牌token
	 * @param b空间  
	 */
	public static String token(String b) {
		
		String bucket =b.isEmpty()?defultbucket:b;
		
		Auth auth = Auth.create(accessKey, secretKey);
		 
		Long expires = (long)3600; 
		
		StringMap putPolicy = new StringMap();
		
		//putPolicy.put("persistentOps", persistentOpfs);
		
		String upToken = auth.uploadToken(bucket, null, expires, putPolicy);
		 
		return upToken;
	}

}
