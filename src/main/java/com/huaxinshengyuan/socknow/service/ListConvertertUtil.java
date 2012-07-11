package com.huaxinshengyuan.socknow.service;

import java.util.ArrayList;
import java.util.List;


public class ListConvertertUtil {
	
	
	public static <T> List<T>  convert(Iterable<T> objects)
	{
		List<T> list = new ArrayList<T>();
		
		for(T c: objects)
		{
			list.add(c);
		}
	    return list;
	}



}
