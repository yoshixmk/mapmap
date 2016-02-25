package com.mycompany.myproject;

import java.util.ArrayList;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.RangeValidator;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;
    private Model<String> mOrderingCompany = new Model<String>();
    private Model<String> mOrderingCompanyAddress = new Model<String>();
    private Model<String> mOrderingContactPersonName = new Model<String>();
    private ArrayList<ProductItem> productItemList = new ArrayList<ProductItem>();
    private ListView<ProductItem> productItemListView;

    public HomePage(final PageParameters parameters) {
        super(parameters);

        Form form = new Form("form"){
//            public void onSubmit() {
//                PrintPage result = new PrintPage((HomePage) this.getParent());
//                setResponsePage(result);
//            }
        };
        form.setOutputMarkupId(true);
        form.add(new Button("nextButton") {
            public void onSubmit() {
                PrintPage result = new PrintPage((HomePage) this.getParent().getParent());
                setResponsePage(result);
            }
        });

        // フォームにテキストフィールドを追加
        TextField field = new TextField<String>("orderingCompany", mOrderingCompany);
        field.setRequired(true);
        field.setOutputMarkupId(true);
        form.add(field);//受注先会社名
        field = new TextField<String>("orderingCompanyAddress", mOrderingCompanyAddress);
        field.setRequired(true);
        field.setOutputMarkupId(true);
        form.add(field);//住所
        field = new TextField<String>("orderingContactPersonName", mOrderingContactPersonName);
        field.setRequired(true);
        field.setOutputMarkupId(true);
        form.add(field);//受注先担当者名

        //最初は項目が1つだけ
        productItemList.add(new ProductItem());

        // リストビュー用のコンテナを作成してフォームに追加
        final WebMarkupContainer container = new WebMarkupContainer("listViewContainer");
        container.setOutputMarkupId(true);

        //項目追加
        container.add(new AjaxButton("productItemAddButton") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                setOutputMarkupId(true);
                // retrieve the product item
                ProductItem item = (ProductItem) getParent().getDefaultModelObject();
                // add the item
                productItemList.add(new ProductItem());

                // repaint the listview as there was a new item added.
                target.add(container);
            }
        });

        form.add(new FeedbackPanel("feedbackMessage"));
        productItemListView = new ListView<ProductItem>("productItemList", productItemList) {
            private static final long serialVersionUID = 1L;
            @Override
            protected void populateItem(ListItem<ProductItem> listItem) {
                final ProductItem productItem = listItem.getModelObject();
                listItem.setModel(new CompoundPropertyModel<ProductItem>(productItem));
                listItem.add(new TextField<String>("productItemName", new PropertyModel<String>(productItem, "productItemName")))
                        .setOutputMarkupId(true);
                listItem.add(new TextField<Integer>("quantity", new PropertyModel<Integer>(productItem, "quantity"))
                        .add(RangeValidator.minimum(0))).setOutputMarkupId(true);
                listItem.add(new TextField<Integer>("unitPrice", new PropertyModel<Integer>(productItem, "unitPrice"))
                        .add(RangeValidator.minimum(0))).setOutputMarkupId(true);
            }
        };
        productItemListView.setReuseItems(true);
        productItemListView.setOutputMarkupId(true);
        container.add(productItemListView);
        form.add(container);
        add(form);
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
