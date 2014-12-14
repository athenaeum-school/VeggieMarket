package jp.com.inotaku.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Customer implements Serializable {

    /**
     */
    private long customerId;

    /**
     */
    private long challengeQuestionId;

    /**
     */
    private String localeCode;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<CustomerAttribute> customerAttributeList = new HashSet<CustomerAttribute>();

	public Customer() {}

	public Customer(long customerId, long challengeQuestionId, String localeCode) {
		super();
		this.customerId = customerId;
		this.challengeQuestionId = challengeQuestionId;
		this.localeCode = localeCode;
	}
    
	
    
}

