package com.example.mymovies;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class NewsController {
    
    public interface EntryChangeListener {
        public void entryChanged(SyndEntry entry);
    }

    private IndexedContainer newsContainer;
    private URL feedUrl;
    private List<EntryChangeListener> entryChangeListeners = 
        new ArrayList<EntryChangeListener>();

    public NewsController() {
        newsContainer = new IndexedContainer();
        newsContainer.addContainerProperty("Date", Date.class, null);
        newsContainer.addContainerProperty("Author", String.class, null);
        newsContainer.addContainerProperty("Title", String.class, null);
    }
    
    public void setFeedUrl(URL newUrl) {
        feedUrl = newUrl;
        refreshContainer();
    }
    
    private void refreshContainer() {
        SyndFeedInput input = new SyndFeedInput();
        try {
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            newsContainer.removeAllItems();
            for (SyndEntry entry : (List<SyndEntry>)feed.getEntries()) {
                Item entryItem = newsContainer.addItem(entry);
                entryItem.getItemProperty("Date").setValue(entry.getPublishedDate());
                entryItem.getItemProperty("Author").setValue(entry.getAuthor());
                entryItem.getItemProperty("Title").setValue(entry.getTitle());
            }
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FeedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public IndexedContainer getContainer() {
        return newsContainer;
    }

    public void selectEntry(SyndEntry value) {
        for (EntryChangeListener listener : entryChangeListeners) {
            listener.entryChanged(value);
        }
    }

    public void addListener(EntryChangeListener listener) {
        entryChangeListeners.add(listener);
    }
}

