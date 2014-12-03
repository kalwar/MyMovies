package com.example.mymovies;

import com.example.mymovies.NewsController.EntryChangeListener;
import com.sun.syndication.feed.synd.SyndEntry;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class BottomView extends Panel implements EntryChangeListener {
    private static final long serialVersionUID = 1L;
    private Label contentLabel;

    public BottomView() {
        super();
        
        setCaption("Good news By Timothy");
        
        contentLabel = new Label("", Label.CONTENT_XHTML);
        this.addComponent(contentLabel);
        this.setSizeFull();
    }

    public void entryChanged(SyndEntry entry) {
        setCaption(entry.getTitle() + " By " + entry.getAuthor());
        contentLabel.setValue(entry.getDescription().getValue());
    }
}








