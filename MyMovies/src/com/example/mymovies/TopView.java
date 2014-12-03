package com.example.mymovies;


import java.net.MalformedURLException;
import java.net.URL;

import com.sun.syndication.feed.synd.SyndEntry;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class TopView extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    public TopView(final NewsController newsController) {
        super();
        
        final TextField urlField = new TextField();
        this.addComponent(urlField);
        urlField.setWidth("100%");
        urlField.addListener(new ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                try {
                    newsController.setFeedUrl(new URL((String)urlField.getValue()));
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        urlField.setImmediate(true);
        
        final Table articleTable = new Table();
        this.addComponent(articleTable);
        articleTable.setWidth("100%");
        articleTable.setContainerDataSource(newsController.getContainer());
        articleTable.setImmediate(true);
        articleTable.setSelectable(true);
        articleTable.addListener(new ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                newsController.selectEntry((SyndEntry) articleTable.getValue());
            }
        });
        
        this.setExpandRatio(articleTable, 1.0f);
    }
    
    
    
    
    
}

