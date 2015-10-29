package com.mycompany.myproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Time;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by yoshihiro on 15/07/28.
 */
public class PrintPage extends WebPage{
    private static final long serialVersionUID = 1L;
    private WebPage formerPage;
    private String[] today = Time.now().toString().split("[.-]");
    private long totalPrice = 0;
    private int sumSubPrice = 0;

    public PrintPage(final HomePage page) {
        this.formerPage=page;
        add(new Label("orderingCompanyValue", page.getMOrderingCompany()));
        add(new Label("orderingCompanyAddressValue", page.getMOrderingCompanyAddress()));
        add(new Label("orderingContactPersonNameValue", page.getMOrderingContactPersonName()));
        add(new Label("todayDate", today[0]+"年"+today[1]+"月"+today[2]+"日"));

        NumberFormat nfNum = NumberFormat.getNumberInstance();

        ArrayList<ProductItem> productItemList;
        productItemList = page.getProductItemList();
        add(new ListView<ProductItem>("productItemList", productItemList) {
            @Override
            protected void populateItem(ListItem<ProductItem> item) {
                NumberFormat nfNum = NumberFormat.getNumberInstance();
                ProductItem productItem = item.getModelObject();
                item.add(new Label("productItem", productItem.getProductItemName()));
                if(productItem.getQuantity() != null) {
                    item.add(new Label("quantity", nfNum.format(productItem.getQuantity())));
                }
                else{
                    item.add(new Label("quantity", productItem.getQuantity()));
                }
                if(productItem.getUnitPrice() != null) {
                    item.add(new Label("unitPrice", nfNum.format(productItem.getUnitPrice())));
                }
                else{
                    item.add(new Label("unitPrice", productItem.getUnitPrice()));
                }
                if(productItem.calcSubtotalPrice() != null) {
                    item.add(new Label("subtotalPrice", nfNum.format(productItem.calcSubtotalPrice())));
                }
                else{
                    item.add(new Label("subtotalPrice", productItem.calcSubtotalPrice()));
                }
            }
        });
        for(ProductItem list : productItemList){
            if(list.calcSubtotalPrice() != null) {
                calcSumSubPrice(list.calcSubtotalPrice());
            }
        }
        add(new Label("sumSubPrice", nfNum.format(sumSubPrice)));
        add(new Label("totalPrice", nfNum.format(getTotalPrice())));
    }

    private void calcSumSubPrice(Integer subTotalPrice){
        sumSubPrice += subTotalPrice;
    }

    private Long getTotalPrice(){
        totalPrice = Math.round(sumSubPrice * 1.08);
        return totalPrice;
    }
}