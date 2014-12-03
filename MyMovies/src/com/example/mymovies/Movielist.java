package com.example.mymovies;

import java.util.ArrayList;
import java.util.List;

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
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
       
        // Add the table headers 
        addContainerProperty("Movie Name", String.class, ""); 
        addContainerProperty("Time", String.class, "0:00"); 
        addContainerProperty("Studio", String.class, "");         
        addContainerProperty("Genre", String.class, ""); 
        //addContainerProperty("Rating", NativeSelect.class, new NativeSelect());
        addContainerProperty("Rating", String.class, ""); 

        // Lets populate the table with random data 
   /*     String[] name = new String[] { "The Dark Knight", "Kung Fu Panda", "Hancock", "Mamma Mia!", "Madagascar: Escape 2 Africa", "Quantum of Solace" }; 
        String[] times = new String[] { "1:12", "1:03", "1:43", "1:32", "1:42", "5:18"}; 
        String[] artists = new String[] { "Warner Bros.", "Paramount", "Columbia", "Universal", "DreamWorks", "MGM / Columbia"};           
        String[] genres = new String[] { "Thriller", "Adventure", "Adventure", "Romantic", "Animation", "Suspense" }; 
        //String[] rating = new String[] {"5 stars", "5 stars", "4 stars", "4 stars","3 stars","1 stars" };
        int[] rating = new int[] {5,5,3,4,1,2 };
   */     
        List<String> name = new ArrayList<String>(10);
        name.add(0,"The Dark Knight");
        name.add(1,"Kung Fu Panda");
        name.add(2,"Hancock");
        name.add(3,"Mamma Mia!");
        name.add(4,"Madagascar");
        name.add(5,"Quantum of Solace");
        
        
        List<String> times = new ArrayList<String>(10);
        times.add(0,"1:35");
        times.add(1,"1:56");
        times.add(2,"1:30");
        times.add(3,"1:45");
        times.add(4,"1:20");
        times.add(5,"1:39");
       
        
        List<String> artists = new ArrayList<String>(10);
        artists.add(0,"Warner Bros.");
        artists.add(1,"Paramount");
        artists.add(2,"Columbia");
        artists.add(3,"Universal");
        artists.add(4,"DreamWorks");
        artists.add(5,"MGM / Columbia");
        
        List<String> genres = new ArrayList<String>(10);
        genres.add(0,"Thriller");
        genres.add(1,"Adventure");
        genres.add(2,"Adventure");
        genres.add(3,"Romantic");
        genres.add(4,"Thriller");
        genres.add(5,"Romantic");
        
        List<Integer> rating = new ArrayList<Integer>(10);
        rating.add(0,5);
        rating.add(1,4);
        rating.add(2,3);
        rating.add(3,2);
        rating.add(4,1);
        rating.add(5,1);
        
        
  /*      
        for (int i = 0; i < 5; i++) { 
            NativeSelect s = new NativeSelect(); 
            s.addItem("1 star"); 
            s.addItem("2 stars"); 
            s.addItem("3 stars"); 
            s.addItem("4 stars"); 
            s.addItem("5 stars"); 
            s.select(i % 5 + " stars"); 
            final int index = i % 16; 
            addItem(new Object[] { name[index], times[index],      
            artists[index], genres[index], s }, i); 
        }
*/
 /*       
        for (int i = 0; i < 5; i++) {            
         //  if((Integer)rating[i] >= rating[i+1])
        	  if (rating.get(i) >= rating.get(i+1))
        	   
           {
        	  // addItem(new Object[] { name[i], times[i],  artists[i], genres[i], rating[i] }, i); 
        		  addItem(new Object[] { name.get(i), times.get(i),  artists.get(i), genres.get(i), rating.get(i)}, i); 
           }
           else
           {
        	   //addItem(new Object[] { name[i+1], times[i+1],  artists[i+1], genres[i+1], rating[i+1] }, i+1); 
        	   //addItem(new Object[] { name[i], times[i],  artists[i], genres[i], rating[i] }, i); 
        	   
        	   addItem(new Object[] { name.get(i+1), times.get(i+1),  artists.get(i+1), genres.get(i+1), rating.get(i+1)}, i);
        	   addItem(new Object[] { name.get(i), times.get(i),  artists.get(i), genres.get(i), rating.get(i)}, i);
        	   i++;
           }
            
        }
  */     
        
        	for (int i = 0; i < 5; i++) {            
           
           		  addItem(new Object[] { name.get(i), times.get(i),  artists.get(i), genres.get(i), rating.get(i)}, i); 
             
               
           }
        
        // We'll align the track time column to right as well 
        setColumnAlignment("Time", Table.ALIGN_RIGHT);
    }

	

	
}

