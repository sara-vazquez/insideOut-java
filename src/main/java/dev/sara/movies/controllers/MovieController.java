package dev.sara.movies.controllers;

import java.time.LocalDate;
import java.util.List;


import dev.sara.movies.repositories.MovieRepositoryCSV;
import dev.sara.movies.services.MovieService;
import dev.sara.movies.models.Movie;
import dev.sara.movies.mappers.MovieMapper;
import dev.sara.movies.dtos.MovieDTO;
import dev.sara.movies.singletons.MovieRepositorySingleton;
import dev.sara.models.Emotion; 






public class MovieController {
    private final MovieRepositoryCSV repository;
    private final MovieService apiService;

    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
        this.apiService = new MovieService(null);
    }

    public void addMovie(String name, Emotion emotion) {
        MovieDTO movieDTO = apiService.findMovieByTitle(name);

        if(movieDTO != null) {
            LocalDate creationDate = LocalDate.now();
            Movie movie = MovieMapper.toEntity(movieDTO, emotion, creationDate);

            repository.save(movie);
            System.out.print("Película añadida con éxito!");
        } else {
            System.out.println("No se encontró la peli. Inténtalo de nuevo.");
        }

    }


}