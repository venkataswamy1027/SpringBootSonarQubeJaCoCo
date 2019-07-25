package com.restapi.common;

import java.util.ArrayList;
import java.util.List;

import com.restapi.model.Item;

public class Common {

	public static Item createAddItem() {
		Item item = new Item();
		item.setId(1);
		item.setName("Redmi");
		item.setCategory("Mobile");
		return item;
	}

	public static Item getItemIdData() {
		return createAddItem();
	}

	public static List<Item> getAllItemsData() {
		List<Item> list = new ArrayList<>();
		list.add(getItemIdData());
		return list;
	}

	public static Item getUpdateItemData() {
		return createAddItem();
	}

	public static Item createDeleteItemData() {
		return createAddItem();
	}

}
