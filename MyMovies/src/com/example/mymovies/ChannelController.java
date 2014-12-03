package com.example.mymovies;


import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

public class ChannelController {

	/**
	 * Interface used for listening to channel list selection changes.
	 * 
	 * @author pyy
	 * 
	 */
	public interface ChannelSelectionChangeListener {
		public void channelEntryChanged(String id);
	}

	/**
	 * Interface used for listening to playlist selection changes.
	 * @author pyy
	 *
	 */
	public interface PlaylistSelectionChangeListener {
		public void playlistEntryChanged (String id);
	}
	
	/**
	 * List of available channels.
	 */
	private IndexedContainer channelList;

	/**
	 * List of available videos in channel.
	 */
	private IndexedContainer videoList;

	/**
	 * List of <code>entryChangeListener</code> that are notified when a channel
	 * selection changes.
	 */
	private List<ChannelSelectionChangeListener> entryChangeListeners = new ArrayList<ChannelSelectionChangeListener>();

	/**
	 * List of <code>PlaylistChangeListener</code> that are notified when a playlist
	 * selection changes.
	 */
	private List<PlaylistSelectionChangeListener> selectionChangeListeners = new ArrayList<PlaylistSelectionChangeListener>();
	
	/**
	 * Constructor.
	 * 
	 * Create initial containers for channel list and playlist and initialize
	 * them; channel list to a available channels for us and playlist to empty.
	 */
	public ChannelController() {
		channelList = new IndexedContainer();
		channelList.addContainerProperty("Movie", String.class, null);

		videoList = new IndexedContainer();
		videoList.addContainerProperty("Promo", String.class, null);
		

		refreshChannelList();
		resetPlaylist();
	}

	/**
	 * Return available channels.
	 * 
	 * @return
	 */
	public Container getChannelList() {
		return channelList;
	}

	/**
	 * Refreshes the available channel list.
	 */
	public void refreshChannelList() {
		// Test data
		Item item = channelList.addItem("1");
		item.getItemProperty("Movie").setValue("The Dark Knight");

		item = channelList.addItem("2");
		item.getItemProperty("Movie").setValue("Kung Fu Panda");

	

		// TODO: Obtain registered channels that are available from data
		// sources
	}

	/**
	 * Adds listener for channel entry changes.
	 * 
	 * @param listener
	 *            <code>EntryChangeListener</code> interface implementation
	 */
	public void addChannelListener(ChannelSelectionChangeListener listener) {
		entryChangeListeners.add(listener);
	}
	
	/**
	 * Adds listener for playlist entry changes.
	 * 
	 * @param listener
	 *            <code>EntryChangeListener</code> interface implementation
	 */
	public void addPlaylistListener(PlaylistSelectionChangeListener listener) {
		selectionChangeListeners.add(listener);
	}

	/**
	 * Notify all listeners that channel entry <code>id</code> is selected.
	 * 
	 * @param id
	 */
	public void selectChannelEntry(String id) {
		for (ChannelSelectionChangeListener entry : entryChangeListeners) {
			entry.channelEntryChanged(id);
		}
	}

	/**
	 * Notify all listeners that playlist entry <code>id</code> is selected.
	 * 
	 * @param id
	 */
	public void selectPlaylistEntry(String id) {
		for (PlaylistSelectionChangeListener entry : selectionChangeListeners) {
			entry.playlistEntryChanged(id);
		}
	}

	
	/**
	 * Load playlist for <code>channelId</code>.
	 * 
	 * @param channelId
	 */
	public void loadPlaylist(String channelId) {
		//System.out.println("Loading playlist for " + jukeboxId);
		if (null == channelId) {
			return;
		}
		// remove old playlist data
		resetPlaylist();

		// load new playlist data
		// test data
		createPlaylist(channelId);
	}

	/**
	 * Return playlist of currently selected channel.
	 * 
	 * @return
	 */
	public Container getPlaylist() {
		return videoList;
	}

	/**
	 * Resets the playlist.
	 */
	public void resetPlaylist() {
		videoList.removeAllItems();
	}

	/* TESTING */

	/**
	 * Test data creation.
	 * 
	 * @param id
	 */
	private void createPlaylist(String id) {
		Item item;
		// Hollywood Records
		if (id.equals("1")) {
			item = videoList.addItem("aKU2zTGfv3w");
			item.getItemProperty("Promo").setValue("Promo 1");
			
			
			item = videoList.addItem("Vp1ZpAkKSxk");
			item.getItemProperty("Promo").setValue("Promo 2");
			
			
		} 
		else if (id.equals("2"))
		{
			item = videoList.addItem("dl7Tx68PUTE");
			item.getItemProperty("Promo").setValue("Promo 1");
			
			
			item = videoList.addItem("GEgk9XsFCR0");
			item.getItemProperty("Promo").setValue("Promo 2");
			
			
		}
		
	}
}

