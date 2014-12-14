package jp.com.inotaku.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@Table(name="customer_attribute")
public class CustomerAttribute {

    /**
     */
    private long customerAttrId;

    /**
     */
    @ManyToOne
    private Customer customer;


    /**
     */
    private String name;

    /**
     */
    private String valueString;
    
    public CustomerAttribute() {}

	public CustomerAttribute(long customerAttrId, 
			String name, String valueString,Customer customer) {
		super();
		this.customerAttrId = customerAttrId;
		this.customer = customer;
		this.name = name;
		this.valueString = valueString;
	}
	
	public CustomerAttribute(long customerAttrId, 
			String name, String valueString) {
		super();
		this.customerAttrId = customerAttrId;
		this.name = name;
		this.valueString = valueString;
	}
    
}
