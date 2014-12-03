package com.example.mymovies;


import com.vaadin.Application;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class MymoviesApplication extends Application implements
Button.ClickListener {
	@Override
	public void init() {
		 buildMainLayout();
		 setMainComponent(getListView());
		
		
		
		
		
	}
	
	//To use this container in our application we add a new field to our	AddressBookApplication together with a getter:
	private MovieContainer dataSource = MovieContainer.createWithTestData();
	 
    public MovieContainer getDataSource() {
         return dataSource;
         }
	
	
	
	
	  //create a field for the ListView in the main application class and create a lazy getter for it 
    private ListView listView = null;
    private Movielist movielist= null;
    private MovieForm movieForm= null;
    
    private ListView getListView() {
         if (listView == null) {
         movielist=new Movielist();
     	 movieForm=new MovieForm();
   	 listView=new ListView(movielist, movieForm);
       }
         return listView;    
         
     }


	private NavigationTree tree = new NavigationTree();
	
    
	//building main layout
		private void buildMainLayout() {
		    setMainWindow(new Window("Address Book Demo application"));
		    
		    //we create a new HorizontalLayout for the toolbar and	populate it with our buttons. 
		    //Finally we add the horizontal split panel to the	window's main layout. 
		    //We have separated the creation of the toolbar to a	method of its own, createToolbar(), to keep the code	cleaner.
		    VerticalLayout layout = new VerticalLayout();
	         layout.setSizeFull();
	                
	         layout.addComponent(createToolbar());
	         layout.addComponent(horizontalSplit);
	        /* Allocate all available extra space to the horizontal split panel */
	        layout.setExpandRatio(horizontalSplit, 1);
	        /* Set the initial split position so we can have a 200 pixel menu to the left */
	        horizontalSplit.setSplitPosition(200, SplitPanel.UNITS_PIXELS);
	        getMainWindow().setContent(layout);
	        
	        //we set it is as the first component for the horizontal split panel in	buildMainLayout().
	        horizontalSplit.setFirstComponent(tree);
	        
	    }
		
		//the main view will always use the right side of the	horizontal split panel. 
		//Let's start by making a generic setter for the main	view
		private void setMainComponent(Component c) {
	         horizontalSplit.setSecondComponent(c);
	     }
		
		
	    public HorizontalLayout createToolbar() {
	        HorizontalLayout lo = new HorizontalLayout();
	         lo.addComponent(newContact);
	         lo.addComponent(search);
	         search.addListener((Button.ClickListener) this);
	         
	        
	         
	         
	         lo.addComponent(share);
	         lo.addComponent(help);
	        return lo;
		      
		}
	    
	    
	    
	

//add some components which should be on the screen all the time.
private Button newContact = new Button("Add contact");
private Button search = new Button("Search");
private Label lb = new Label("fuck");

public void buttonClick(ClickEvent event) {
	// TODO Auto-generated method stub
	final Button source = event.getButton();
	if (source == search) {
	    showSearchView();
	}
}

private Button share = new Button("Share");
private Button help = new Button("Help");
private SplitPanel horizontalSplit = new SplitPanel(
        SplitPanel.ORIENTATION_HORIZONTAL);





private void showSearchView() {
	// TODO Auto-generated method stub
	setMainComponent(getSearchView());
}

private Component getSearchView() {
	return lb;
	// TODO Auto-generated method stub
	
}
}