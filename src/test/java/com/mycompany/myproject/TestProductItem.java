package com.mycompany.myproject;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestProductItem {
//	テストクラスの命名規則「XxxTest.java」
//	テストメソッドの命名規則「testXxx()」
//	テストメソッドの前に「@Test」を付ける
//	テストメソッドは「引数なし」+「返り値なし」
//	テストメソッドに 「assertEquals("error時の文",期待値,実測値)」

	//同一の内容であるかをテストする
	@Test
	public void testSameContents() {
		ProductItem productItem1 = new ProductItem();
		productItem1.setProductItemName("パソコン");
		productItem1.setUnitPrice(30000);
		productItem1.setQuantity(10);

		ProductItem productItem2 = new ProductItem();
		productItem2.setProductItemName("パソコン");
		productItem2.setUnitPrice(30000);
		productItem2.setQuantity(10);
		//assertThat(productItem.equals(productItem2), is(true));
		assertThat(productItem1, is(productItem2));
	}

	//正しく小計が計算されるかをテストする
	@Test
	public void testCalcSubtotalPrice() {
		ProductItem productItem = new ProductItem();
		productItem.setProductItemName("パソコン");
		productItem.setUnitPrice(30000);
		productItem.setQuantity(10);
		assertThat(productItem.calcSubtotalPrice(), is(300000));
	}
}
