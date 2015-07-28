package com.mycompany.myproject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Created by yoshihiro on 15/07/28.
 */
public class PrintPage extends WebPage{
    private static final long serialVersionUID = 1L;

    public PrintPage() {
        super.add(new Label("nextMessage", "これは2ページ目です。"));
    }
}
