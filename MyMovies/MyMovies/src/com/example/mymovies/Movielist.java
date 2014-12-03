package com.example.mymovies;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Table;


public class Movielist extends Table {
   
	
	
	Movielist(){
		 setSizeFull();
		setContainerDataSource(getContainerDataSource());
		//The setContainerDataSource() sets the data source for	the table to our own MovieContainer.
/*	// create some dummy data
        addContainerProperty("Movie Name", String.class, "Hulk");
        addContainerProperty("Your Rating", String.class, "*****");
        addContainerProperty("Genre", String.class, "Love Story");
        addContainerProperty("Your Rating", String.class, "*****");
        addContainerProperty("Your Rating", String.class, "*****");
        addItem();
        addItem();
 */     
		
		
       
        setSelectable(true); 
       
        // Add the table headers 
        addContainerProperty("Name", String.class, ""); 
       addContainerProperty("Time", String.class, "0:00"); 
        addContainerProperty("Artist", String.class, ""); 
        addContainerProperty("Album", String.class, ""); 
        addContainerProperty("Genre", String.class, ""); 
        addContainerProperty("Rating", NativeSelect.class, 
                new NativeSelect());

        // Lets populate the table with random data 
        String[] tracks = new String[] { "Red Flag", "Millstone", 
                "Not The Sun", "Breath", "Here We Are", "Deep Heaven", 
                "Her Voice Resides", "Natural Tan", "End It All", "Kings", 
                "Daylight Slaving", "Mad Man", "Resolve", "Teargas", 
                "African Air", "Passing Bird" }; 
        String[] times = new String[] { "4:12", "6:03", "5:43", "4:32", "3:42", 
                "4:45", "2:56", "9:34", "2:10", "3:44", "5:49", "6:30", "5:18", 
                "7:42", "3:13", "2:52" }; 
        String[] artists = new String[] { "Billy Talent", "Brand New", 
                "Breaking Benjamin", "Becoming The Archetype", 
                "Bullet For My Valentine", "Chasing Victory", "Chimaira", 
                "Danko Jones", "Deadlock", "Deftones", "From Autumn To Ashes", 
                "Haste The Day", "Four Year Strong", "In Flames", "Kemopetrol", 
                "John Legend" }; 
        String[] albums = new String[] { "Once Again", "The Caitiff Choir", 
    
                        "The Devil And God", "Light Grenades", "Dicthonomy", 
                "Back In Black", "Dreamer", "Come Clarity", "Year Zero", 
                "Frames", "Fortress", "Phobia", "The Poison", "Manifesto", 
                "White Pony", "The Big Dirty" }; 
        String[] genres = new String[] { "Rock", "Metal", "Hardcore", "Indie", 
                "Pop", "Alternative", "Blues", "Jazz", "Hip Hop", 
                "Electronica", "Punk", "Hard Rock", "Dance", "R'n'B", "Gospel", 
                "Country" }; 
        for (int i = 0; i < 10; i++) { 
            NativeSelect s = new NativeSelect(); 
            s.addItem("1 star"); 
            s.addItem("2 stars"); 
            s.addItem("3 stars"); 
            s.addItem("4 stars"); 
            s.addItem("5 stars"); 
            s.select(i % 5 + " stars"); 
            final int index = i % 16; 
            addItem(new Object[] { tracks[index], times[index], 
                    artists[index], albums[index], genres[index], s }, i); 
        }

        // We'll align the track time column to right as well 
        setColumnAlignment("Time", Table.ALIGN_RIGHT);
    }

	

	
}

