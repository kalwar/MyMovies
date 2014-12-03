package com.example.mymovies;

import com.vaadin.ui.SplitPanel;


public class ListView extends SplitPanel {
     public ListView() {
     }
     public ListView(Movielist movielist, MovieForm movieForm) {
    	 
    	 //add first component such as movie lists and second component movie form
    	 setFirstComponent(movielist);
         setSecondComponent(movieForm);
         setSplitPosition(40);
	}
	//To minimize start-up time and memory usage we will use a lazy initialization	pattern for creating our views. 
     //In an application this small it doesn't	actually matter, 
     //but generally it is a very good habit to lazily instantiate you GUI objects.
     private ListView listView = null;
     private ListView getListView() {
          if (listView == null) {
              listView = new ListView();
              
             
              
          }
          return listView;
      }
     
     
     
     
 }


