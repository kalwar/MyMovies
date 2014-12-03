package com.example.mymovies;


import com.vaadin.ui.SplitPanel;

public class MainView extends SplitPanel {
    private static final long serialVersionUID = 1L;

    public MainView() {
        super(SplitPanel.ORIENTATION_VERTICAL);
        this.setSizeFull();
        
        NewsController newsController = new NewsController();
                
        setFirstComponent(new TopView(newsController));
        BottomView bottom = new BottomView();
        newsController.addListener(bottom);
        setSecondComponent(bottom);
    }
}
