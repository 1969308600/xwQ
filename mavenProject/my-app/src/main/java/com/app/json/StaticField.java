package com.app.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticField {
	
	@SuppressWarnings("rawtypes")
	static Map<Class,CompositeI> map = new HashMap<>();
	static {
		map.put(String.class, new CompositeIsFiled() );
		map.put(float.class, new CompositeIsFiled() );
		map.put(int.class, new CompositeIsFiled() );
		map.put(char.class, new CompositeIsFiled() );
		map.put(byte.class, new CompositeIsFiled() );
		map.put(double.class, new CompositeIsFiled() );
		map.put(long.class, new CompositeIsFiled() );
		map.put(short.class, new CompositeIsFiled() );
		
		
		map.put(List.class, new CompositeIsList() );
		map.put(short.class, new CompositeIsFiled() );
	}

}
