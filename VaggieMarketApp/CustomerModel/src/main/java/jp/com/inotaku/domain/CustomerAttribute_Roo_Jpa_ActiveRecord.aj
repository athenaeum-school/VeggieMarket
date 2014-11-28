// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package jp.com.inotaku.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jp.com.inotaku.domain.CustomerAttribute;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CustomerAttribute_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager CustomerAttribute.entityManager;
    
    public static final List<String> CustomerAttribute.fieldNames4OrderClauseFilter = java.util.Arrays.asList("customerAttrId", "customer", "name", "valueString");
    
    public static final EntityManager CustomerAttribute.entityManager() {
        EntityManager em = new CustomerAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CustomerAttribute.countCustomerAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CustomerAttribute o", Long.class).getSingleResult();
    }
    
    public static List<CustomerAttribute> CustomerAttribute.findAllCustomerAttributes() {
        return entityManager().createQuery("SELECT o FROM CustomerAttribute o", CustomerAttribute.class).getResultList();
    }
    
    public static List<CustomerAttribute> CustomerAttribute.findAllCustomerAttributes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CustomerAttribute o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CustomerAttribute.class).getResultList();
    }
    
    public static CustomerAttribute CustomerAttribute.findCustomerAttribute(Long id) {
        if (id == null) return null;
        return entityManager().find(CustomerAttribute.class, id);
    }
    
    public static List<CustomerAttribute> CustomerAttribute.findCustomerAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CustomerAttribute o", CustomerAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<CustomerAttribute> CustomerAttribute.findCustomerAttributeEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CustomerAttribute o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CustomerAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void CustomerAttribute.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CustomerAttribute.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CustomerAttribute attached = CustomerAttribute.findCustomerAttribute(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CustomerAttribute.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CustomerAttribute.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CustomerAttribute CustomerAttribute.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CustomerAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}