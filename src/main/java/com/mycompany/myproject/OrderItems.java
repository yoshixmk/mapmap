package com.mycompany.myproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class OrderItems implements Serializable{
	private List<ProductItem> productItemList;
	private static double TAX_RATE = 0.08;
	private int sumSubPrice;
	private int totalPrice;
	private int consumptionTax;

	public OrderItems(){
		productItemList =new ArrayList<ProductItem>();
	}

	public void addProductItem(ProductItem productItem){
		productItemList.add(productItem);
	}

	public ProductItem getProductItem(int index){
		return productItemList.get(index);
	}

	public int size(){
		return productItemList.size();
	}

	public int getsumSubPrice(){
		sumSubPrice = 0;
		IntStream.range(0, productItemList.size()).forEach(i->{
			sumSubPrice += productItemList.get(i).getUnitPrice();
		});
		//sumSubPrice = productItemList.stream().forEach(s -> s.getUnitPrice());
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
    	if (this == anObject){
  	      return true;
      	}
  	    if (!(anObject instanceof OrderItems)){
  	      return false;
  	    }
  	    OrderItems otherOrderItems = (OrderItems)anObject;
  	    if(productItemList.size() == otherOrderItems.size()){
	  	    for(int i=0; i<productItemList.size(); i++){
	  	    	if(!getProductItem(i).equals(otherOrderItems.getProductItem(i))){
	  	    		return false;
	  	    	}
	  	    }
  	    }
  	    else{
  	    	return false;
  	    }
  	    return true;
    }
}
