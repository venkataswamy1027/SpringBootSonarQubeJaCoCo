package com.restapi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

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
import com.restapi.repository.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceTest.class);

	@MockBean
	ItemRepository itemRepository;

	@Autowired
	ItemService itemService;

	@Test
	public void testCreateItem() {
		LOGGER.info("testCreateItem method executed");
		// ARRANGE
		Item createItem = Common.createAddItem();
		when(itemRepository.save(createItem)).thenReturn(createItem);
		itemService.createItem(createItem);
	}

	@Test
	public void testItemById() {
		LOGGER.info("testItemById method executed");
		// ARRANGE
		Item item = Common.getItemIdData();
		when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));
		// ACT
		Item response = itemService.getItemById(item.getId());
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, item);
	}

	@Test
	public void testGetAllItems() {
		LOGGER.info("testGetAllItems method executed");
		// ARRANGE
		List<Item> items = Common.getAllItemsData();
		when(itemRepository.findAll()).thenReturn(items);
		// ACT
		List<Item> response = itemService.list();
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, items);
	}

	@Test
	public void testUpdateItem() {
		LOGGER.info("testUpdateItem method executed");
		// ARRANGE
		Item item = Common.getUpdateItemData();
		when(itemRepository.save(item)).thenReturn(item);
		// ACT
		Item response = itemService.update(item, item.getId());
		LOGGER.info("response {}", response);
		// ASSERT
		assertEquals(response, response);
	}
	
	@Test
	public void testDeleteItem() {
		LOGGER.info("testDeleteItem method executed");
		// ARRANGE
		Item item = Common.createDeleteItemData();
		// ACT
		itemService.delete(item.getId());
	}
}
