package com.mycompany.myproject;

import lombok.Data;

import java.io.Serializable;

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
}
