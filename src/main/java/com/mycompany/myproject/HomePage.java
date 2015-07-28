package com.mycompany.myproject;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		//add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		Form form = new Form("form");
		Button nextButton = new Button("nextButton") {
			private static final long serialVersionUID = 1L;
			public void onSubmit() {
				setResponsePage(PrintPage.class);
			}
		};
		form.add(nextButton);
		super.add(form);

		// TODO Add your page's components here

    }
}
