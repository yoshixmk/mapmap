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
    private int sumPrice = 0;

    public PrintPage(HomePage page) {
        this.formerPage=page;
        add(new Label("orderingCompanyValue", page.getMOrderingCompany()));
        add(new Label("orderingCompanyAddressValue", page.getMOrderingCompanyAddress()));
        add(new Label("orderingContactPersonNameValue", page.getMOrderingContactPersonName()));
        add(new Label("todayDate", today[0]+"年"+today[1]+"月"+today[2]+"日"));

        NumberFormat nfNum = NumberFormat.getNumberInstance();
        ArrayList<ProductItem> productItemList = new ArrayList<ProductItem>();
        if(page.getMProductItem1().getObject()!=null && page.getMQuantity1().getObject()!=null && page.getMUnitPrice1().getObject()!=null) {
            ProductItem item1 = new ProductItem();
            item1.setProductItem(page.getMProductItem1().getObject().toString());
            item1.setQuantity(nfNum.format(Integer.parseInt(page.getMQuantity1().getObject().toString())));
            item1.setUnitPrice(nfNum.format(Integer.parseInt(page.getMUnitPrice1().getObject().toString())));
            productItemList.add(item1);
            int subtotalPrice = calcAmountOfMoney(page.getMQuantity1(), page.getMUnitPrice1());
            item1.setSubtotalPrice(nfNum.format(Integer.parseInt(String.valueOf(subtotalPrice))));
            sumPrice += subtotalPrice;
        }
        if(page.getMProductItem2().getObject()!=null && page.getMQuantity2().getObject()!=null && page.getMUnitPrice2().getObject()!=null) {
            ProductItem item2 = new ProductItem();
            item2.setProductItem(page.getMProductItem2().getObject().toString());
            item2.setQuantity(nfNum.format(Integer.parseInt(page.getMQuantity2().getObject().toString())));
            item2.setUnitPrice(nfNum.format(Integer.parseInt(page.getMUnitPrice2().getObject().toString())));
            productItemList.add(item2);
            int subtotalPrice = calcAmountOfMoney(page.getMQuantity2(), page.getMUnitPrice2());
            item2.setSubtotalPrice(nfNum.format(Integer.parseInt(String.valueOf(subtotalPrice))));
            sumPrice += subtotalPrice;
        }
        if(page.getMProductItem3().getObject()!=null && page.getMQuantity3().getObject()!=null && page.getMUnitPrice3().getObject()!=null) {
            ProductItem item3 = new ProductItem();
            item3.setProductItem(page.getMProductItem3().getObject().toString());
            item3.setQuantity(nfNum.format(Integer.parseInt(page.getMQuantity3().getObject().toString())));
            item3.setUnitPrice(nfNum.format(Integer.parseInt(page.getMUnitPrice3().getObject().toString())));
            productItemList.add(item3);
            int subtotalPrice = calcAmountOfMoney(page.getMQuantity3(), page.getMUnitPrice3());
            item3.setSubtotalPrice(nfNum.format(Integer.parseInt(String.valueOf(subtotalPrice))));
            sumPrice += subtotalPrice;
        }
        if(page.getMProductItem4().getObject()!=null && page.getMQuantity4().getObject()!=null && page.getMUnitPrice4().getObject()!=null) {
            ProductItem item4 = new ProductItem();
            item4.setProductItem(page.getMProductItem4().getObject().toString());
            item4.setQuantity(nfNum.format(Integer.parseInt(page.getMQuantity4().getObject().toString())));
            item4.setUnitPrice(nfNum.format(Integer.parseInt(page.getMUnitPrice4().getObject().toString())));
            productItemList.add(item4);
            int subtotalPrice = calcAmountOfMoney(page.getMQuantity4(), page.getMUnitPrice4());
            item4.setSubtotalPrice(nfNum.format(Integer.parseInt(String.valueOf(subtotalPrice))));
            sumPrice += subtotalPrice;
        }
        if(page.getMProductItem5().getObject()!=null && page.getMQuantity5().getObject()!=null && page.getMUnitPrice5().getObject()!=null) {
            ProductItem item5 = new ProductItem();
            item5.setProductItem(page.getMProductItem5().getObject().toString());
            item5.setQuantity(nfNum.format(Integer.parseInt(page.getMQuantity5().getObject().toString())));
            item5.setUnitPrice(nfNum.format(Integer.parseInt(page.getMUnitPrice5().getObject().toString())));
            productItemList.add(item5);
            int subtotalPrice = calcAmountOfMoney(page.getMQuantity5(), page.getMUnitPrice5());
            item5.setSubtotalPrice(nfNum.format(Integer.parseInt(String.valueOf(subtotalPrice))));
            sumPrice += subtotalPrice;
        }
        add(new ListView<ProductItem>("productItemList", productItemList) {
            @Override
            protected void populateItem(ListItem<ProductItem> item) {
                NumberFormat nfNum = NumberFormat.getNumberInstance();
                ProductItem productItem = item.getModelObject();
                item.add(new Label("productItem", productItem.getProductItem()));
                item.add(new Label("quantity", productItem.getQuantity()));
                item.add(new Label("unitPrice", productItem.getUnitPrice()));
                item.add(new Label("subtotalPrice", productItem.getSubtotalPrice()));
            }
        });

        add(new Label("sumPrice", nfNum.format(sumPrice)));
    }

    public Integer calcAmountOfMoney(Model quantityValue, Model unitPriceValue){
        return Integer.parseInt(quantityValue.getObject().toString()) * Integer.parseInt(unitPriceValue.getObject().toString());
    }
}