package com.mycompany.myproject;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestOrderItems{
	//同一の内容であるかをテストする
	@Test
	public void testSameContents() {
		ProductItem productItem1 = new ProductItem();
		productItem1.setProductItemName("パソコン");
		productItem1.setUnitPrice(30000);
		productItem1.setQuantity(10);
		OrderItems orderItems1 = new OrderItems();
		orderItems1.addProductItem(productItem1);

		ProductItem productItem2 = new ProductItem();
		productItem2.setProductItemName("パソコン");
		productItem2.setUnitPrice(30000);
		productItem2.setQuantity(10);
		OrderItems orderItems2 = new OrderItems();
		orderItems2.addProductItem(productItem2);

		assertThat(orderItems1, is(orderItems2));
	}

	//getsumSubPrice()の取得結果が正しいかテストする
	@Test
	public void testGetsumSubPrice(){
		ProductItem productItem1 = new ProductItem();
		productItem1.setProductItemName("パソコン");
		productItem1.setUnitPrice(30000);
		productItem1.setQuantity(10);

		ProductItem productItem2 = new ProductItem();
		productItem2.setProductItemName("ノートパソコン");
		productItem2.setUnitPrice(50000);
		productItem2.setQuantity(20);

		OrderItems orderItems = new OrderItems();
		orderItems.addProductItem(productItem1);
		orderItems.addProductItem(productItem2);
		int answer = 30000 * 10 + 50000 * 20;
		assertThat(orderItems.getsumSubPrice(), is(answer));
	}

	//getTotalPrice()の取得結果が正しいかテストする
	@Test
	public void testGetTotalPrice(){
		ProductItem productItem1 = new ProductItem();
		productItem1.setProductItemName("パソコン");
		productItem1.setUnitPrice(30000);
		productItem1.setQuantity(10);

		ProductItem productItem2 = new ProductItem();
		productItem2.setProductItemName("ノートパソコン");
		productItem2.setUnitPrice(50000);
		productItem2.setQuantity(20);

		OrderItems orderItems = new OrderItems();
		orderItems.addProductItem(productItem1);
		orderItems.addProductItem(productItem2);
		int answer = (int) ((30000 * 10 + 50000 * 20) * 1.08);
		assertThat(orderItems.getsumSubPrice(), is(answer));
	}

	//getConsumptionTax()の取得結果が正しいかテストする
	@Test
	public void testGetConsumptionTax(){
		ProductItem productItem1 = new ProductItem();
		productItem1.setProductItemName("パソコン");
		productItem1.setUnitPrice(30000);
		productItem1.setQuantity(10);

		ProductItem productItem2 = new ProductItem();
		productItem2.setProductItemName("ノートパソコン");
		productItem2.setUnitPrice(50000);
		productItem2.setQuantity(20);

		OrderItems orderItems = new OrderItems();
		orderItems.addProductItem(productItem1);
		orderItems.addProductItem(productItem2);
		int answer = (int) ((30000 * 10 + 50000 * 20) * 0.08);
		assertThat(orderItems.getConsumptionTax(), is(answer));
	}
}
