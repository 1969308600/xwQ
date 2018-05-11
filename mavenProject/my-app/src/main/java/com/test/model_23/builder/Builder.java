package com.test.model_23.builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {//建造模式
	private List<Builder> list = new ArrayList<Builder>(); 
	
	public Builder( ) {
		
	}
	
	public Builder(int n) {
		if(n>0)
		for(int i=0;i<n;i++) {
			list.add(new Builder());
		}
	}
 
	public Builder getBuilderByIndex(int index) {
		return list.get(index);
	}
}
