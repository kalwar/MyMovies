package com.example.addressbook;




import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

//this should be changed to movie form to input movies name, basic description etc...
public class MovieForm extends Form {
    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    public MovieForm() {
         addField("Movie Name", new TextField("Movie Name"));
         addField("Your Rating", new ComboBox("Your Rating"));
         HorizontalLayout footer = new HorizontalLayout();
         footer.setSpacing(true);
         footer.addComponent(save);
         footer.addComponent(cancel);
         setFooter(footer);
     }
}