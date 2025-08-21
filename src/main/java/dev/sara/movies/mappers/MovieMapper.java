package dev.sara.movies.mappers;

import dev.sara.movies.dtos.MovieDTO;
import dev.sara.movies.models.Movie;

public class MovieMapper {
    public static Movie toEntity(MovieDTO dto) {

    return new Movie(dto.name(), dto.genres(), dto.emotion(), dto.releaseYear(), dto.creationDate());
    }

}
