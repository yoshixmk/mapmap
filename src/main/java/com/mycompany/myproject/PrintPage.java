package com.mycompany.myproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

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
    }

    public void formerPage(HomePage page){
        formerPage = page;
    }
}


/*
package com.mycompany.myproject;

        import org.apache.wicket.markup.html.WebPage;
        import org.apache.wicket.markup.html.basic.Label;
        import org.apache.wicket.markup.html.form.Form;
        import org.apache.wicket.markup.html.form.TextArea;

public class PrintPage extends WebPage {
    private static final long serialVersionUID = -8680953158566804713L;
    private WebPage formerPage;
    private Form form = new Form("f") {

        private static final long serialVersionUID = 5522440160951241211L;

        @Override
        protected void onSubmit() {
            setResponsePage(formerPage);
        }
    };

    public PrintPage(HomePage page) {
        this.formerPage=page;
        add(new Label("subject",page.getMSubject()));
        add(new Label("type",page.getMType()));
        add(new Label("date",page.getMDate()));
        add(new TextArea("article",page.getMArticle()));
        add(form);
    }
}
 */
