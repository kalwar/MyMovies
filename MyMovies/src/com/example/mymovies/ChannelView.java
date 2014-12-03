package com.example.mymovies;


import com.example.mymovies.ChannelController.PlaylistSelectionChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ChannelView extends VerticalLayout implements PlaylistSelectionChangeListener {
	
	private static final long serialVersionUID = 1L;
	
	private ChannelController control;	
	private GridLayout grid;
	private Embedded player;
	
	/**
	 * Constructor.
	 * @param control
	 */
	public ChannelView(ChannelController control) {
		this.control = control;
		grid = new GridLayout (2,1);
		grid.setSizeFull();
		this.addComponent(grid);
		
		// Embedded video player
		player = new Embedded();
		player.setWidth(352 + "px");
		player.setHeight(255 + "px");
		grid.addComponent(player, 0,0);
		
		grid.setComponentAlignment(player, Alignment.MIDDLE_LEFT);

		player.setType(Embedded.TYPE_OBJECT);
        player.setMimeType("application/x-shockwave-flash");
        
        // load available channels
		refreshChannelList();
	}
	
	/**
	 * Populates the channel list table from data provided by ChannelController.
	 */
	public void refreshChannelList ()
	{
		final Table channelList = new Table();
		
		channelList.setSizeUndefined();
		channelList.setPageLength(5);
		channelList.setSortDisabled(true);		
		grid.addComponent(channelList,1,0);
		grid.setComponentAlignment(channelList, Alignment.TOP_LEFT);
		
		channelList.setContainerDataSource(control.getChannelList());
		channelList.setSelectable(true);
		channelList.setImmediate(true);
		channelList.setSizeFull();
		channelList.setNullSelectionAllowed(false);		
		
		channelList.addListener(new ValueChangeListener() {			
		
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				control.selectChannelEntry((String)channelList.getValue());
			}
		});
	}

	@Override
	public void playlistEntryChanged(String id) {
		
		// if there is no id selected default to LUT introduction
		/*if (null == id)
		{
			id = "aKU2zTGfv3w";
		}*/
		String url = "http://www.youtube.com/v/"+ id +"&autoplay=1";
		
        player.setSource(new ExternalResource(url));		
	}
}
