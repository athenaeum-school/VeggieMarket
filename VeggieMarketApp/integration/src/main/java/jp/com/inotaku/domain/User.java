package jp.com.inotaku.domain;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    private String userName;

    @NotNull
    private String password;

    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Authorities> authorities = new HashSet<Authorities>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	public User(){}

	public User(String userName, String password, boolean enabled) {
		super();
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", enabled=" + enabled + ", authorities=" + authorities + "]";
	}


    
    
}
