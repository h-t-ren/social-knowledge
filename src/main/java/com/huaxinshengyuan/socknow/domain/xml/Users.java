package com.huaxinshengyuan.socknow.domain.xml;

import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import com.huaxinshengyuan.socknow.domain.User;

@XmlRootElement(name="users")
public class Users {
	
	private Collection<User> user;

	public Collection<User> getUser() {
		return user;
	}

	public void setUser(Collection<User> user) {
		this.user = user;
	}

}
