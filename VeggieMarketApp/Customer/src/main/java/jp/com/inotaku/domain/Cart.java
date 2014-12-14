package jp.com.inotaku.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Delegate
	private List<ItemSet> itemSetList = new ArrayList<ItemSet>();

}
