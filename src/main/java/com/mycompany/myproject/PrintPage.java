package com.mycompany.myproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

/**
 * Created by yoshihiro on 15/07/28.
 */
public class PrintPage extends WebPage{
    private static final long serialVersionUID = 1L;
    private WebPage formerPage;

    public PrintPage(HomePage page) {
        this.formerPage=page;
        add(new Label("nextMessage", "これは2ページ目です。"));
        add(new Label("orderingCompanyValue", page.getMOrderingCompany()));
        add(new Label("orderingCompanyAddressValue", page.getMOrderingCompanyAddress()));
        add(new Label("orderingContactPersonNameValue", page.getMOrderingContactPersonName()));
        add(new Label("productItemValue1", page.getMProductItem1()));
        add(new Label("productItemValue2", page.getMProductItem2()));
        add(new Label("productItemValue3", page.getMProductItem3()));
        add(new Label("productItemValue4", page.getMProductItem4()));
        add(new Label("productItemValue5", page.getMProductItem5()));
        add(new Label("quantityValue1", page.getMQuantity1()));
        add(new Label("quantityValue2", page.getMQuantity2()));
        add(new Label("quantityValue3", page.getMQuantity3()));
        add(new Label("quantityValue4", page.getMQuantity4()));
        add(new Label("quantityValue5", page.getMQuantity5()));
        add(new Label("unitPriceValue1", page.getMUnitPrice1()));
        add(new Label("unitPriceValue2", page.getMUnitPrice2()));
        add(new Label("unitPriceValue3", page.getMUnitPrice3()));
        add(new Label("unitPriceValue4", page.getMUnitPrice4()));
        add(new Label("unitPriceValue5", page.getMUnitPrice5()));
        add(new Label("amountOfMoneyValue1", page.getMAmountOfMoney1()));
        add(new Label("amountOfMoneyValue2", page.getMAmountOfMoney2()));
        add(new Label("amountOfMoneyValue3", page.getMAmountOfMoney3()));
        add(new Label("amountOfMoneyValue4", page.getMAmountOfMoney4()));
        add(new Label("amountOfMoneyValue5", page.getMAmountOfMoney5()));

        add(new Label("calcAmountOfMoney1", calcAmountOfMoney(page.getMQuantity1(), page.getMUnitPrice1())));
    }

    public void formerPage(HomePage page){
        formerPage = page;
    }
    public Integer calcAmountOfMoney(Model quantityValue, Model unitPriceValue){
        return Integer.parseInt(quantityValue.getObject().toString()) * Integer.parseInt(unitPriceValue.getObject().toString());
    }
}
