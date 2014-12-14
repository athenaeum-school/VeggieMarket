package jp.com.inotaku.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "item")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "item_id")
	private long itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "description")
	private String description;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Item(){}

	public Item(String itemName, int price, String description) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.description = description;
	}

	public Item(long itemId, String itemName, int price, String description) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price="
				+ price + ", description=" + description + "]";
	}
	
	
	
	
}
