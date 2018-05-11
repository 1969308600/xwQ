package com.test.api;

import java.util.ArrayList;
 

/**
 * 	docs say:
 * 
 *  When the annotation is applied to a
 *  field or method, the container will inject an instance
 *  of the requested resource into the application component
 *  when the component is initialized.
 *  @author worker
 *
 */
public class ResourceTest {
	public void resource() {
		ArrayList<Object> list =new ArrayList<Object>();
		list.forEach((t)->{});
		System.out.println("resource inject!");
	}
}
