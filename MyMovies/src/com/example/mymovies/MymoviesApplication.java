package com.example.mymovies;

/*
import com.example.myeasymovies.BottomView;
import com.example.myeasymovies.NewsController;
import com.example.myeasymovies.TopView;
*/
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class MymoviesApplication extends Application implements
Button.ClickListener {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//create a field for the ListView in the main application class and create a lazy getter for it 
    private ListView listView = null;
    private Movielist movielist= null;
    private MovieForm movieForm= null;
	
	//add some components which should be on the screen all the time.
	private Button home = new Button("HOME");
	private Button search = new Button("Search");
	//private TextField tf = new TextField("show");
	private Label lb = new Label("show");
	
	private NavigationTree tree = new NavigationTree();
	private Label la = new Label("This is to Share");
	private Button share = new Button("Share");
	private Button help = new Button("Help");
	private Label lc = new Label("This is to Help");
	private SplitPanel horizontalSplit = new SplitPanel(
	        SplitPanel.ORIENTATION_HORIZONTAL);
	
	 private static final String CAPTION1 = "Search in Location";
	 private static final String TOOLTIP1 = "Search threater in specific location";
	 VerticalLayout layout = new VerticalLayout();
	 Window subwindow;
	 Table ta = new Table();
	
	@Override
	public void init() {
		 buildMainLayout();
		 setMainComponent(getListView());
		setTheme("mymoviestheme");
		
		
		
		
		
	}
	
	//To use this container in our application we add a new field to our	AddressBookApplication together with a getter:
	private MovieContainer dataSource = MovieContainer.createWithTestData();
	 
    public MovieContainer getDataSource() {
         return dataSource;
         }
	
	
	
	
	 
    
    private ListView getListView() {
         if (listView == null) {
         movielist=new Movielist();
     	 movieForm=new MovieForm();
   	 listView=new ListView(movielist, movieForm);
       }
         return listView;    
         
     }


	
	
    
	//building main layout
		private void buildMainLayout() {
	   
		    setMainWindow(new Window("Address Book Demo application"));
		
		    //we create a new HorizontalLayout for the toolbar and	populate it with our buttons. 
		    //Finally we add the horizontal split panel to the	window's main layout. 
		    //We have separated the creation of the toolbar to a	method of its own, createToolbar(), to keep the code	cleaner.
		    //VerticalLayout layout = new VerticalLayout();
	         layout.setSizeFull();
	               
	         Label lb = new Label();
	        lb.addStyleName("v-panel-p");
	        lb.setWidth("100%");
	        lb.setHeight("150px");
	        layout.addComponent(lb);
	         
	         layout.addComponent(createToolbar());
	         layout.addComponent(horizontalSplit);
	        /* Allocate all available extra space to the horizontal split panel */
	        layout.setExpandRatio(horizontalSplit, 1);
	        
	     
	        
	        /* Set the initial split position so we can have a 200 pixel menu to the left */
	        horizontalSplit.setSplitPosition(200, SplitPanel.UNITS_PIXELS);
	        getMainWindow().setContent(layout);
	        
	     // Link w/ text and tooltip
	        Link lin1 = new Link(CAPTION1, new ExternalResource("http://www.google.com/movies?near=helsinki"));
	        lin1.setDescription(TOOLTIP1);         
	        layout.addComponent(lin1);
	        
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
	         lo.addComponent(home);
	         lo.addComponent(search);
	         search.addListener((Button.ClickListener) this);
	         
	         lo.addComponent(share);
	         share.addListener((Button.ClickListener) this);
	         
	         lo.addComponent(help);
	         help.addListener((Button.ClickListener) this);
	         	
	        return lo;
		      
		}
	    
	    
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			final Button source = event.getButton();
			if (source == search) {
			    showSearchView();
			}
			if (source == share) {
			    showShareView();
			}
			if (source == help) {
			    showHelpView();
			}
		}
			
			


		private void showHelpView() {
			// TODO Auto-generated method stub
			 setMainComponent(getHelpView());
		}






		





		private void showShareView() {
			// TODO Auto-generated method stub
			 setMainComponent(getShareView());
			
		}






		private void showSearchView() {
					
			HorizontalLayout top = new HorizontalLayout();
		    top.setWidth("100%");
		    top.setMargin(true, true, true, true); // Enable horizontal margins
		    top.setSpacing(true);
		   
		    
		    NewsController newsController = new NewsController();
		    top.addComponent(new TopView(newsController));  
		    //root.addComponent(top);
		    BottomView bottom1 = new BottomView();
		    newsController.addListener(bottom1);
		    top.addComponent(bottom1);
		    
		    
		    setMainComponent(getSearchView());
		    //--------------------------------------------------------------------
		   
		    
		}

		private Component getSearchView() {
			return lb;
			// TODO Auto-generated method stub
			
		}
		
		private Component getShareView() {
			return la;
			// TODO Auto-generated method stub
			
		}
		
		private Component getHelpView() {
			return lc;
			// TODO Auto-generated method stub
			
		}
		
		
		
		
}