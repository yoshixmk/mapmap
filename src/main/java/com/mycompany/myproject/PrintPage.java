package com.mycompany.myproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Time;

/**
 * Created by yoshihiro on 15/07/28.
 */
public class PrintPage extends WebPage{
    private static final long serialVersionUID = 1L;
    private WebPage formerPage;
    private String[] today = Time.now().toString().split("[.-]");

    public PrintPage(HomePage page) {
        this.formerPage=page;
        add(new Label("orderingCompanyValue", page.getMOrderingCompany()));
        add(new Label("orderingCompanyAddressValue", page.getMOrderingCompanyAddress()));
        add(new Label("orderingContactPersonNameValue", page.getMOrderingContactPersonName()));
        add(new Label("todayDate", today[0]+"年"+today[1]+"月"+today[2]+"日"));
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
        if(page.getMQuantity1().getObject()!=null && page.getMUnitPrice1().getObject()!=null) {
            add(new Label("calcAmountOfMoney1", calcAmountOfMoney(page.getMQuantity1(), page.getMUnitPrice1())));
        }
        else{
            add(new Label("calcAmountOfMoney1", "１の単価または数量に空欄があります"));
        }
        if(page.getMQuantity2().getObject()!=null && page.getMUnitPrice2().getObject()!=null){
            add(new Label("calcAmountOfMoney2", calcAmountOfMoney(page.getMQuantity2(), page.getMUnitPrice2())));
        }
        else{
            add(new Label("calcAmountOfMoney2", "２の単価または数量に空欄があります"));
        }
        if(page.getMQuantity3().getObject()!=null && page.getMUnitPrice3().getObject()!=null){
            add(new Label("calcAmountOfMoney3", calcAmountOfMoney(page.getMQuantity3(), page.getMUnitPrice3())));
        }
        else{
            add(new Label("calcAmountOfMoney3", "３の単価または数量に空欄があります"));
        }
        if(page.getMQuantity4().getObject()!=null && page.getMUnitPrice4().getObject()!=null){
            add(new Label("calcAmountOfMoney4", calcAmountOfMoney(page.getMQuantity4(), page.getMUnitPrice4())));
        }
        else{
            add(new Label("calcAmountOfMoney4", "４の単価または数量に空欄があります"));
        }
        if(page.getMQuantity5().getObject()!=null && page.getMUnitPrice5().getObject()!=null){
            add(new Label("calcAmountOfMoney5", calcAmountOfMoney(page.getMQuantity5(), page.getMUnitPrice5())));
        }
        else{
            add(new Label("calcAmountOfMoney5", "５の単価または数量に空欄があります"));
        }
    }

    public Integer calcAmountOfMoney(Model quantityValue, Model unitPriceValue){
        return Integer.parseInt(quantityValue.getObject().toString()) * Integer.parseInt(unitPriceValue.getObject().toString());
    }
}
