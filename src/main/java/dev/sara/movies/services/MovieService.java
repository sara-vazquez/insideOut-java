package dev.sara.movies.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.sara.movies.daos.ApiMoviesDAO;
import dev.sara.movies.dtos.MovieDTO;

public class MovieService {

    public MovieService(ApiMoviesDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
    
    private final ApiMoviesDAO movieDAO;

    public MovieDTO findMovieById(String imdbId) {
        String movieData = movieDAO.getMovie(imdbId);

        if(movieData != null && !movieData.isEmpty()) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(movieData, MovieDTO.class);
        }
        return null;
    }

   /* public JsonObject getMovieInfo(String imdbId) {
        
        String movieData = movieDAO.getMovie(imdbId);

        StringReader reader = new StringReader(movieData);
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

        return jsonObject;
    }
     */

}
