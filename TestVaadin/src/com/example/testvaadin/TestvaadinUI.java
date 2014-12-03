package com.example.testvaadin;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("testvaadin")
public class TestvaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = TestvaadinUI.class)
	public static class Servlet extends VaadinServlet {
	}
   
	@Override
	protected void init(VaadinRequest request) {
		 FilesystemContainer docs = new FilesystemContainer(new File("/Users/santoshkalwar/Downloads"));
		    Table doclist = new Table ("Documents", docs);
		    DocEditor docView = new DocEditor();
			setContent(doclist);
			
			HorizontalSplitPanel split = new HorizontalSplitPanel();
			setContent(split);
			split.addComponent(doclist);
			split.addComponent(docView);
			doclist.setSizeFull();
			
			doclist.addValueChangeListener(new ValueChangeListener() {
			
				public void valueChange(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					docView.setPropertyDataSource(new TextFileProperty((File) event.getProperty().getValue()));
					
				}
				
			});
		doclist.setImmediate(true);
		doclist.setSelectable(true);
	}

}