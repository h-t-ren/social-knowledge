package com.huaxinshengyuan.socknow.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("serial")
@XmlRootElement(name="user")
public class User extends KnowledgeNode {

    private static final String SALT = "yibayan";
    public static final String FRIEND = "FRIEND";
    public static final String RATED = "RATED";
    @Indexed(indexName="login")
    private String login;
    private String name;
    private String password;
    private String info;
    private Role[] roles;
    
    @Autowired
    private  Md5PasswordEncoder md5Encoder;

    public User() {
    }

    public User(String login, String name, String password, Role... role) {
        this.login = login;
        this.name = name;
        this.password = encode(password);
        this.roles = role;
    }

    private String encode(String password) {
        return  md5Encoder.encodePassword(password, SALT);
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

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
    public void updatePassword(String old, String newPass1, String newPass2) {
        if (!password.equals(encode(old))) throw new IllegalArgumentException("Existing Password invalid");
        if (!newPass1.equals(newPass2)) throw new IllegalArgumentException("New Passwords don't match");
        this.password = encode(newPass1);
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

  


}
