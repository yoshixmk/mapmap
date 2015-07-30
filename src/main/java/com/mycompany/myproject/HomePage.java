package com.mycompany.myproject;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private Model mOrderingCompany = new Model();
	private Model mOrderingCompanyAddress = new Model();
	private Model mOrderingContactPersonName = new Model();
	private Model mProductItem1 = new Model();
	private Model mProductItem2 = new Model();
	private Model mProductItem3 = new Model();
	private Model mProductItem4 = new Model();
	private Model mProductItem5 = new Model();
	private Model mQuantity1 = new Model();
	private Model mQuantity2 = new Model();
	private Model mQuantity3 = new Model();
	private Model mQuantity4 = new Model();
	private Model mQuantity5 = new Model();
	private Model mUnitPrice1 = new Model();
	private Model mUnitPrice2 = new Model();
	private Model mUnitPrice3 = new Model();
	private Model mUnitPrice4 = new Model();
	private Model mUnitPrice5 = new Model();
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
//				PrintPage resultPrintPage = new PrintPage((HomePage) this.getParent());
//				setResponsePage(resultPrintPage);
//				setResponsePage((HomePage) this.getParent());
			}
		};
		form.add(nextButton);
//		super.add(form);

		// ここから追加分

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
		field = new TextField("productItem1", mProductItem1);
		field.setOutputMarkupId(true);
		form.add(field);//項目
		field = new TextField("productItem2", mProductItem2);
		field.setOutputMarkupId(true);
		form.add(field);//項目
		field = new TextField("productItem3", mProductItem3);
		field.setOutputMarkupId(true);
		form.add(field);//項目
		field = new TextField("productItem4", mProductItem4);
		field.setOutputMarkupId(true);
		form.add(field);//項目
		field = new TextField("productItem5", mProductItem5);
		field.setOutputMarkupId(true);
		form.add(field);//項目
		field = new TextField("quantity1", mQuantity1);
		field.setOutputMarkupId(true);
		form.add(field);//数量
		field = new TextField("quantity2", mQuantity2);
		field.setOutputMarkupId(true);
		form.add(field);//数量
		field = new TextField("quantity3", mQuantity3);
		field.setOutputMarkupId(true);
		form.add(field);//数量
		field = new TextField("quantity4", mQuantity4);
		field.setOutputMarkupId(true);
		form.add(field);//数量
		field = new TextField("quantity5", mQuantity5);
		field.setOutputMarkupId(true);
		form.add(field);//数量
		field = new TextField("unitPrice1", mUnitPrice1);
		field.setOutputMarkupId(true);
		form.add(field);//単価
		field = new TextField("unitPrice2", mUnitPrice2);
		field.setOutputMarkupId(true);
		form.add(field);//単価
		field = new TextField("unitPrice3", mUnitPrice3);
		field.setOutputMarkupId(true);
		form.add(field);//単価
		field = new TextField("unitPrice4", mUnitPrice4);
		field.setOutputMarkupId(true);
		form.add(field);//単価
		field = new TextField("unitPrice5", mUnitPrice5);
		field.setOutputMarkupId(true);
		form.add(field);//単価


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
	public Model getMProductItem1() {
		return mProductItem1;
	}
	public Model getMProductItem2() {
		return mProductItem2;
	}
	public Model getMProductItem3() {
		return mProductItem3;
	}
	public Model getMProductItem4() {
		return mProductItem4;
	}
	public Model getMProductItem5() {
		return mProductItem5;
	}
	public Model getMQuantity1() {
		return mQuantity1;
	}
	public Model getMQuantity2() {
		return mQuantity2;
	}
	public Model getMQuantity3() {
		return mQuantity3;
	}
	public Model getMQuantity4() {
		return mQuantity4;
	}
	public Model getMQuantity5() {
		return mQuantity5;
	}
	public Model getMUnitPrice1() {
		return mUnitPrice1;
	}
	public Model getMUnitPrice2() {
		return mUnitPrice2;
	}
	public Model getMUnitPrice3() {
		return mUnitPrice3;
	}
	public Model getMUnitPrice4() {
		return mUnitPrice4;
	}
	public Model getMUnitPrice5() {
		return mUnitPrice5;
	}
}
