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
		final TextField field = new TextField("orderingCompany", mOrderingCompany);
		field.setOutputMarkupId(true);
		form.add(field);

//		super.add(form);

		// TODO Add your page's components here

    }

	public Model getMOrderingCompany() {
		return mOrderingCompany;
	}
}

/*
package com.mycompany.myproject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 3598788934381254916L;

	private Form form = new Form("f") {
		private static final long serialVersionUID = -1700095884500348972L;

		@Override
		protected void onSubmit() {
			PrintPage result = new PrintPage((HomePage) this.getParent());
			setResponsePage(result);
		}
	};

	private Model mSubject = new Model();

	private Model mType = new Model();

	private Model mDate = new Model(new Date());

	private Model mArticle = new Model();

	private FeedbackPanel feedback = new FeedbackPanel("msg");

	public HomePage(final PageParameters parameters) {

		add(feedback);

		add(form);

		TextField txtSubject = new TextField("subject", mSubject);
		txtSubject.setRequired(true);
		form.add(txtSubject);

		List<String> typeList = new ArrayList<String>();
		typeList.add("Diary");
		typeList.add("Book Review");
		typeList.add("Tech Memo");
		typeList.add("Diet");
		// If you want to set the Default Value of combo box,
		// write like following.
		//mType.setObject("Diary");
		DropDownChoice cmbType =new DropDownChoice("type", mType, typeList);
		cmbType.setRequired(true);
		form.add(cmbType);

		TextField txtDate = new TextField("date", mDate,Date.class);
		txtDate.setRequired(true);
		form.add(txtDate);

		TextArea txtArticle = new TextArea("article", mArticle);
		txtArticle.setRequired(true);
		form.add(txtArticle);
	}

	public Model getMSubject() {
		return mSubject;
	}

	public Model getMType() {
		return mType;
	}

	public Model getMDate() {
		return mDate;
	}

	public Model getMArticle() {
		return mArticle;
	}
}

*/