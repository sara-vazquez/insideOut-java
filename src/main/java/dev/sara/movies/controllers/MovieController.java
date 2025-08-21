package dev.sara.movies.controllers;

import java.util.ArrayList;
import java.util.List;

import dev.sara.movies.repositories.MovieRepositoryCSV;
import dev.sara.movies.singletons.MovieRepositorySingleton;



public class MovieController {
    private final MovieRepositoryCSV repository;

    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
    }


}