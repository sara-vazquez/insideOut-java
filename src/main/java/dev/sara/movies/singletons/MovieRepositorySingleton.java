package dev.sara.movies.singletons;

import dev.sara.movies.repositories.MovieRepositoryCSV;

public class MovieRepositorySingleton {
    
    private static MovieRepositoryCSV INSTANCE;

    private MovieRepositorySingleton() {}

    public static MovieRepositoryCSV getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieRepositoryCSV();
        }
        return INSTANCE;
    }
}
