package jp.com.inotaku.domain;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;

    private String roleName;


    @ManyToOne
    private User consumer;



	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getConsumer() {
		return consumer;
	}

	public void setConsumer(User consumer) {
		this.consumer = consumer;
	}
    
    public Authorities(){}
    
    public Authorities(String roleName){
    	super();
    	this.roleName = roleName;
    }

	public Authorities(String roleName, User consumer) {
		super();
		this.roleName = roleName;
		this.consumer = consumer;
	}

	@Override
	public String toString() {
		return "Authorities [roleName=" + roleName + ", consumer=" + consumer
				+ "]";
	}
    
    
}
