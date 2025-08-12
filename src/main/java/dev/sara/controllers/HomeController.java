package dev.sara.controllers;

import dev.sara.views.HomeView;

public class HomeController {
    
    public HomeController() {
        index();
    }

    public void index() {
        HomeView.printMenu();
    }
}
