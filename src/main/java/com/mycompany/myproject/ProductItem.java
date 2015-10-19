package com.mycompany.myproject;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yoshihiro on 2015/10/19.
 */
@Data
public class ProductItem implements Serializable{
    private String productItem;
    private String quantity;
    private String unitPrice;
    private String subtotalPrice;
}
