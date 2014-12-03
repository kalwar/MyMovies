package com.example.mymovies;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Tree;
import com.vaadin.terminal.ExternalResource;

//Create a NavigationTree class extending the Tree	component in a new package called "ui".
public class NavigationTree extends Tree {
    public static final Object SEARCH_LOCATION = "Search location";
    public static final Object SEARCH_VIDEOS = "Search videos";
    
    private static final String CAPTION1 = "Search in Location";
	private static final String TOOLTIP1 = "Search threater in specific location";
   
	public NavigationTree() {
            addItem(SEARCH_LOCATION);
            addItem(SEARCH_VIDEOS);
            
  /*      // Link w/ text and tooltip
            Link lin1 = new Link(CAPTION1, new ExternalResource("http://www.google.com/movies"));
            lin1.setDescription(TOOLTIP1);
            addItem(lin1);
    */        
           
    }
}