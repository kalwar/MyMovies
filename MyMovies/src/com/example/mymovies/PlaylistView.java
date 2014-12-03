package com.example.mymovies;


import com.example.mymovies.ChannelController.ChannelSelectionChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PlaylistView extends VerticalLayout implements ChannelSelectionChangeListener {
	
	private static final long serialVersionUID = 1L;	
	private ChannelController control;
	private final Table playlist;
	
	/**
	 * Constructor.
	 * @param channelController
	 */
	public PlaylistView(ChannelController channelController) {
		this.control = channelController;
				
		playlist = new Table();
		this.addComponent(playlist);
		playlist.setWidth("100%");
		
		// listener for getting which song is selected
        playlist.addListener(new ValueChangeListener() {			
			
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {							
				control.selectPlaylistEntry((String)playlist.getValue());
			}
		});
		
		refreshPlaylist();
	}

	/**
	 * Refresh content of the playlist view to contain playlist data
	 * from selected channel.
	 */
	public void refreshPlaylist ()
	{		
		playlist.setSelectable(true);
		playlist.setImmediate(true);		
		playlist.setPageLength(10);
		playlist.setSortDisabled(true);
		playlist.setContainerDataSource(control.getPlaylist());		
	}

	@Override
	public void channelEntryChanged(String id) {		
		
		// reset playlist if there is no channel selected
		if (null == id)
		{
			control.resetPlaylist();
		}
		else
		{		
			// load data to container
			control.loadPlaylist(id);
		}
		// refresh container information to ui
		refreshPlaylist ();
	}
}
