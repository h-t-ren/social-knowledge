package com.huaxinshengyuan.socknow.domain.enums;

public enum Permission {
	
	READ(100),WRITE(110),ALL(111);
	
    Permission(int permission)
	{
		this.permission= permission;
	}
	private int permission;   
	
	public int getPermission()
	{
		return this.permission;
	}
	public static Permission valueOf(int permission)
	{
		Permission p= Permission.READ;
		switch(permission)
		{
		   case 100:
		   p = Permission.READ; break;
		   case 110:
		   p= Permission.WRITE;break;
		   case 111:
		   p= Permission.ALL;break;
		}
		return p;
	}
}
