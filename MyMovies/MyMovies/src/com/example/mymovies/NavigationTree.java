package com.example.mymovies;

import com.vaadin.ui.Tree;

//Create a NavigationTree class extending the Tree	component in a new package called "ui".
public class NavigationTree extends Tree {
    public static final Object SHOW_ALL = "Show all";
    public static final Object SEARCH = "Search";
   public NavigationTree() {
            addItem(SHOW_ALL);
            addItem(SEARCH);
    }
}