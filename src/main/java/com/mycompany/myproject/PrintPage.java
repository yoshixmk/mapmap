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
                ProductItem productItem = item.getModelObject();
                item.add(new Label("productItem", productItem.getProductItemName()));
                item.add(new Label("quantity", productItem.getQuantity()));
                item.add(new Label("unitPrice", productItem.getUnitPrice()));
                item.add(new Label("subtotalPrice", productItem.calcSubtotalPrice()));
            }
        });

        add(new Label("sumPrice", nfNum.format(sumPrice)));
    }
}