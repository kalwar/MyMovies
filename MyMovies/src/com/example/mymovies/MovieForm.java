package com.example.mymovies;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;




public class MovieForm extends Form implements Button.ClickListener{
    Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    //ComboBox cb;
    public MovieForm() {
    
        
         addField("Movie Name", new TextField("MovieName"));
         addField("Time", new TextField("Time"));
         addField("Studio", new TextField("Studio"));
         addField("Genre", new TextField("Genre"));
         addField("Rating", new TextField("Rating"));
         //addField("Rating", new ComboBox("Rating"));
         
         
         HorizontalLayout footer = new HorizontalLayout();
         footer.setSpacing(true);
         footer.addComponent(save);
         footer.addComponent(cancel);
         setFooter(footer);
         
         
         
      
         ChannelController channelController = new ChannelController();
         
 		Label caption = new Label ("<b>Movie Promo</b><br>");
 		caption.setSizeUndefined();
 		footer.addComponent(caption);
 		caption.setContentMode(Label.CONTENT_XHTML);
 				
 		SplitPanel split = new SplitPanel(SplitPanel.ORIENTATION_HORIZONTAL);
 		split.setHeight("100%");
 		split.setWidth("100%");
 		footer.addComponent(split);
 		footer.setComponentAlignment(split, Alignment.BOTTOM_CENTER);
 		
 		split.setLocked(true);
 		split.setMargin(true);
 		split.addStyleName("remotejukeboxstyle");
 		
 		ChannelView channelView = new ChannelView(channelController);
 		footer.addComponent(channelView);
 		channelController.addPlaylistListener(channelView);
 		
 		PlaylistView playlist = new PlaylistView(channelController);
 		footer.addComponent(playlist);
 		channelController.addChannelListener(playlist);
 		
 		footer.setComponentAlignment(caption, Alignment.TOP_CENTER);
 		

         
     }
    
    public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		final Button source = event.getButton();
		if (source == save) {
			addField("Rat", new TextField("Rat"));
		}
		
	}
}