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

	//set values and get values test
	@Test
	public void testSetValueGetValue() {
		ProductItem productItem = new ProductItem();
		productItem.setProductItemName("パソコン");
		productItem.setUnitPrice(30000);
		productItem.setQuantity(10);
		assertThat("名前が違います", productItem.getProductItemName(), is("パソコン"));
		assertThat("価格が違います", productItem.getUnitPrice(), is(30000));
		assertThat("個数が違います", productItem.getQuantity(), is(10));

		productItem.setProductItemName("ノートパソコン");
		productItem.setUnitPrice(50000);
		productItem.setQuantity(3);
		assertThat("名前が違います", productItem.getProductItemName(), is("ノートパソコン"));
		assertThat("価格が違います", productItem.getUnitPrice(), is(50000));
		assertThat("個数が違います", productItem.getQuantity(), is(3));
	}

	//null values test
	@Test
	public void testGetNullValue() {
		ProductItem productItem = new ProductItem();
		assertThat("名前が初期化されています", productItem.getProductItemName(), nullValue());
		assertThat("価格が初期化されています", productItem.getUnitPrice(), nullValue());
		assertThat("個数が初期化されています", productItem.getQuantity(), nullValue());
	}

}
