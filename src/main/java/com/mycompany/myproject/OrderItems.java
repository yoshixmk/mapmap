package com.mycompany.myproject;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrderItems implements Serializable{
	private List<ProductItem> productItemList;
	private static double TAX_RATE = 0.08;
	private int sumSubPrice = 0;
	private int totalPrice = 0;
	private int consumptionTax = 0;

	void addProductItem(ProductItem productItem){

	}

	ProductItem getProductItem(){
		return new ProductItem();
	}

	public int getsumSubPrice(){
		return sumSubPrice;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

    public int getConsumptionTax(){
        return consumptionTax;
    }

    @Override
    public boolean equals(Object anObject)
    {
    	/*if (this == anObject){
  	      return true;
      	}
  	    if (!(anObject instanceof ProductItem)){
  	      return false;
  	    }
  	    ProductItem otherProductItem = (ProductItem) anObject;
  	    if(productItemName.equals(otherProductItem.getProductItemName())){
  	    	if(quantity.equals(otherProductItem.getQuantity())){
  	    		if(unitPrice.equals(otherProductItem.getUnitPrice())){
      	    		return true;
      	    	}
  	    	}
  	    }*/
  	    return false;
    }
}
