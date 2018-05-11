package com.app.json;

public class Test {
	public static void main(String[] args) {
		
		Objectodt dt = new Objectodt();
		Objectodt2 dt2 = new Objectodt2();
		dt.setId("1");
		dt.setName("nicai");
		dt2.setName("test");
		dt2.setName("test");
		dt.setDt(dt2);
		JsonObj.obj = dt;
		
		
		//≤‚ ‘≤„
		JsonObj jo = new JsonObj().init(dt, new CompositeIsFiled());
		String jsonStr = jo.getStr();
		System.out.println(jsonStr);
	}
}
