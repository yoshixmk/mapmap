package com.mycompany.myproject;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by yoshihiro on 2015/10/19.
 */
@Data
public class ProductItem implements Serializable{
    private String productItemName;
    private Integer quantity;
    private Integer unitPrice;

    Integer calcSubtotalPrice(){
        if(quantity==null || unitPrice==null) {
            return null;
        }
        else{
            return quantity * unitPrice;
        }
    }

    @Override
    public boolean equals(Object anObject)
    {
    	if (this == anObject)
    	      return true;
    	    if (!(anObject instanceof ProductItem))
    	      return false;
    	    ProductItem otherProductItem = (ProductItem) anObject;
    	    if(productItemName.equals(otherProductItem.getProductItemName())){
    	    	if(quantity.equals(otherProductItem.getQuantity())){
    	    		if(unitPrice.equals(otherProductItem.getUnitPrice())){
        	    		return true;
        	    	}
    	    	}
    	    }
    	    return false;
    }
}
