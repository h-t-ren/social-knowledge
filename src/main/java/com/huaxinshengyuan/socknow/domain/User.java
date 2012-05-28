package com.huaxinshengyuan.socknow.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@XmlRootElement(name="user")
public class User extends KnowledgeNode {


    public static final String FRIEND = "FRIEND";
    public static final String RATED = "RATED";
    @Indexed(indexName="login", unique=true)
    private String login;
    private String name;
	private String password;
   

	private String info;
    private Role[] roles;
    

    public User() {
    }

    public User(String login, String name, String password, Role... role) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.roles = role;
    }



    @RelatedTo(type = FRIEND, direction = Direction.BOTH)
    @Fetch Set<User> friends;
    public void addFriend(User friend) {
        this.friends.add(friend);
    }

  
    @Override
    public String toString() {
        return String.format("%s (%s)", name, login);
    }

    public String getName() {
        return name;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public Role[] getRoles() {
        return roles;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFriend(User other) {
        return other!=null && getFriends().contains(other);
    }



	public void setLogin(String login) {
		this.login = login;
	}



	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

  


}
