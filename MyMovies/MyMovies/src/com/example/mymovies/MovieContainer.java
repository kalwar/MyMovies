package com.example.mymovies;


import java.io.Serializable;
import java.util.Random;

import com.vaadin.data.util.BeanItemContainer;
public class MovieContainer extends BeanItemContainer<Movie> implements
Serializable {

/**
* Natural property order for Person bean. Used in tables and forms.
*/
public static final Object[] NATURAL_COL_ORDER = new Object[] {
	"MovieName", "Rating", "Usefullink", "Description" };

/**
* "Human readable" captions for properties in same order as in
* NATURAL_COL_ORDER.
*/
public static final String[] COL_HEADERS_ENGLISH = new String[] {
	"Movie Name", "Your Rating", "Recommended links", "Short Description"
	 };

public MovieContainer() throws InstantiationException,
	IllegalAccessException {
super(Movie.class);
}

public static MovieContainer createWithTestData() {
final String[] Mnames = { "Hulk", "A love story", "Terminator", "Tommorrow never comes", "Must love dogs",
		"Secret Window", "Beautiful Mind", "Nothing else matters", "Dan", "Borat", "In her Shoes", "Romeo and Juliet",
		"Let's Rock", "Made for each other" };
final String[] Rating = { "**", "****", "**", "**",
		"*", "**", "***", "***", "****", "****",
		"**", "***", "***", "***", "***" };

final String[] Genre = { "Action", "Lovestory", "Action", "Thriller",
		"Suspence", "Drama", "Documentary", "Bio", "Lovestory", "Action",
		"Drama", "Bio", "Suspence", "Thriller", "Lovestory" };

final String Description[] = { "sdnfaksdf", "asdfasdfasdf",
		"asdfasdfasdf", "asdfasdfasdf", "adsfasdfasdf",
		"asdfasdfadsf", "sdfasdfasdfadsf",
		"asdfasdfasdf", "asdfdsafadsasdfadsf",
		"asdfdasfasd", "asdfasdf",
		"asdfasdfasf", "asdfasdfads",
		"asdfadsfasdf", "asdfadsfasdf",
		"asdfasdfasdf", "asdfasdfasdfadsf",
		"asdfasdfasdf", "asdfasdfasdf",
		"dsafasdfasdfdasf.", "539-3675 Magna Avenue",
		"Ap #357-5640 Pharetra Avenue", "416-2983 Posuere Rd.",
		"141-1287 Adipiscing Avenue", "Ap #781-3145 Gravida St.",
		"6897 Suscipit Rd.", "8336 Purus Avenue", "2603 Bibendum. Av.",
		"2870 Vestibulum St.", "Ap #722 Aenean Avenue",
		"446-968 Augue Ave", "1141 Ultricies Street",
		"Ap #992-5769 Nunc Street", "6690 Porttitor Avenue",
		"Ap #105-1700 Risus Street",
		"P.O. Box 532, 3225 Lacus. Avenue", "736 Metus Street",
		"414-1417 Fringilla Street", "Ap #183-928 Scelerisque Road",
		"561-9262 Iaculis Avenue" };
MovieContainer c = null;
Random r = new Random(0);
try {
	c = new MovieContainer();
	for (int i = 0; i < 100; i++) {
		Movie p = new Movie();
		p.setMovieName(Mnames[r.nextInt(Mnames.length)]);
		p.setRating(Rating[r.nextInt(Rating.length)]);
		p.Genre(Genre[r.nextInt(Genre.length)]);
		int n = r.nextInt(100000);
		if (n < 10000) {
			n += 10000;
		}
		
		p.setDescription(Description[r.nextInt(Description.length)]);
		
		c.addItem(p);
	}
} catch (InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return c;
}

}