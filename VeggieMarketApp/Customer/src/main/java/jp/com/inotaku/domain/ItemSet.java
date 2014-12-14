package jp.com.inotaku.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;
	
	private int quantity;
}
