package com.mycompany.myproject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private Model mOrderingCompany = new Model();
	private Model mOrderingCompanyAddress = new Model();
	private Model mOrderingContactPersonName = new Model();
	private ArrayList<ProductItem> productItemList = new ArrayList<ProductItem>();

//	private Model mProductItem1 = new Model();
//	private Model mProductItem2 = new Model();
//	private Model mProductItem3 = new Model();
//	private Model mProductItem4 = new Model();
//	private Model mProductItem5 = new Model();
//	private Model mQuantity1 = new Model();
//	private Model mQuantity2 = new Model();
//	private Model mQuantity3 = new Model();
//	private Model mQuantity4 = new Model();
//	private Model mQuantity5 = new Model();
//	private Model mUnitPrice1 = new Model();
//	private Model mUnitPrice2 = new Model();
//	private Model mUnitPrice3 = new Model();
//	private Model mUnitPrice4 = new Model();
//	private Model mUnitPrice5 = new Model();
	private Form form = new Form("form") {
		private static final long serialVersionUID = -1700095884500348972L;

		@Override
		protected void onSubmit() {
			PrintPage result = new PrintPage((HomePage) this.getParent());
			setResponsePage(result);
		}
	};

	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(form);

		Button nextButton = new Button("nextButton") {
			private static final long serialVersionUID = 1L;
			public void onSubmit() {
			}
		};
		form.add(nextButton);

		// フォームにテキストフィールドを追加
		TextField field = new TextField("orderingCompany", mOrderingCompany);
		field.setOutputMarkupId(true);
		form.add(field);//受注先会社名
		field = new TextField("orderingCompanyAddress", mOrderingCompanyAddress);
		field.setOutputMarkupId(true);
		form.add(field);//住所
		field = new TextField("orderingContactPersonName", mOrderingContactPersonName);
		field.setOutputMarkupId(true);
		form.add(field);//受注先担当者名
		for(int i=0; i<5; i++) {
			productItemList.add(new ProductItem());
		}
		form.add(new ListView<ProductItem>("productItemList", productItemList) {
			@Override
			protected void populateItem(ListItem<ProductItem> listItem) {
				ProductItem productItem = listItem.getModelObject();
				listItem.add(new TextField<String>("productItemName", new PropertyModel<String>(productItem, "productItemName")));
				listItem.add(new TextField<Integer>("quantity", new PropertyModel<Integer>(productItem, "quantity")));
				listItem.add(new TextField<Integer>("unitPrice", new PropertyModel<Integer>(productItem, "unitPrice")));
			}
		});

		// TODO Add your page's components here

    }

	public Model getMOrderingCompany() {
		return mOrderingCompany;
	}
	public Model getMOrderingCompanyAddress() {
		return mOrderingCompanyAddress;
	}
	public Model getMOrderingContactPersonName() {
		return mOrderingContactPersonName;
	}
	public ArrayList<ProductItem> getProductItemList() {
		return productItemList;
	}
}
