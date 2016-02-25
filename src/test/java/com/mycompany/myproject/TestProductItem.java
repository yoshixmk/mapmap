package com.mycompany.myproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProductItem {

	//set values and get values test
	@Test
	public void setValueGetValue() {
		ProductItem productItem = new ProductItem();
		productItem.setProductItemName("パソコン");
		productItem.setUnitPrice(3000);
		productItem.setQuantity(10);
		assertEquals("名前が違います", "パソコン", productItem.getProductItemName());
		assertEquals("価格が違います", new Integer(3000), productItem.getUnitPrice());
		assertEquals("個数が違います", new Integer(10), productItem.getQuantity());
	}

	//null values test
	@Test
	public void getNullValue() {
		ProductItem productItem = new ProductItem();
		assertNull("名前が違います", productItem.getProductItemName());
		assertNull("価格が違います", productItem.getUnitPrice());
		assertNull("個数が違います", productItem.getQuantity());
	}

}
