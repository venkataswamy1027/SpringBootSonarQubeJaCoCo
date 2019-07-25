package com.restapi.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.restapi.common.Common;
import com.restapi.model.Item;
import com.restapi.service.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemControllerTest.class);
	@MockBean
	ItemService itemService;

	@Autowired
	private ItemController itemController;

	@Test
	public void testaddItem() {
		LOGGER.info("testaddItem method executed");
		// ARRANGE
		Item createItem = Common.createAddItem();
		LOGGER.info("createItem {}", createItem);
		when(itemService.createItem(createItem)).thenReturn(createItem);
		// ACT
		Item response = itemController.addItem(createItem);
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, createItem);
	}

	@Test
	public void testItemById() {
		LOGGER.info("testItemById method executed");
		// ARRANGE
		Item item = Common.getItemIdData();
		when(itemService.getItemById(item.getId())).thenReturn(item);
		// ACT
		Item response = itemController.getItem(item.getId());
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, item);
	}

	@Test
	public void testGetAllItems() {
		LOGGER.info("testGetAllItems method executed");
		// ARRANGE
		List<Item> items = Common.getAllItemsData();
		when(itemService.list()).thenReturn(items);
		// ACT
		List<Item> response = itemController.getAllItems();
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, items);
	}

	@Test
	public void testUpdateItem() {
		LOGGER.info("testUpdateItem method executed");
		// ARRANGE
		Item item = Common.getUpdateItemData();
		when(itemService.update(item, item.getId())).thenReturn(item);
		// ACT
		Item response = itemController.updateItem(item, item.getId());
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, response);
	}

	@Test
	public void testDeleteItem() {
		LOGGER.info("testDeleteItem method executed");
		// ARRANGE
		Item item = Common.createDeleteItemData();
		String message = "item " + item.getId() + " deleted successfully.";
		// ACT
		String response = itemController.deleteItem(item.getId());
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, message);
	}
}
