package dev.sara.movies.repositories;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import dev.sara.models.Emotion;
import dev.sara.movies.models.Movie;

public class MovieRepositoryCSV {

    private List<Movie> movies;
    private static final String CSV_FILE_PATH = "movies.csv";

    public MovieRepositoryCSV() {
        this.movies = new ArrayList<>();
        loadFromCSV();
    }

   /*  public void loadFromCSV() {
        try(Reader reader = new Reader(new FileReader(CSV_FILE_PATH))) {
            String line;
            reader.readLine();

            while((line = reader.readLine()) != null ) {
                String[] data = line.split(",");
                if(data.length >= 5) {
                    try {
                        String name = data[0];
                        List<String> genres = Arrays.asList(data[1].split("\\|"));
                        Emotion emotion = Emotion.valueOf(data[2]);
                        String releaseYear = data[3];
                        String creationDate = data[4];

                        Movie movie = new Movie(name, genres, emotion, releaseYear, creationDate);
                        this.movies.add(movie);
                    } catch (Exception e) {
                        System.err.println("Error al parsear la línea: " + line);
                    } 
                }
            }
        }catch (IOException e) {
            // Este mensaje es útil para saber si el archivo no existe
            System.err.println("Archivo CSV no encontrado. Se creará uno nuevo en la próxima exportación.");
        }
    } */

    public void save(Movie movie) {
        this.movies.add(movie);
        System.out.println("Película guardada en CSV: " + movie.getName());
    }

    public List<Movie> getAll() {
        return this.movies;
    }
    
    public void exportMoviesCSV(String filePath) {

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Título,Género/s,Emoción,Estreno,Creación\n");

            for(Movie movie : this.movies) {
                writer.append(movie.getName());
                writer.append(",");
                writer.append(String.join("|", movie.getGenres()));
                writer.append(",");
                writer.append(movie.getEmotion().name());
                writer.append(",");
                writer.append(movie.getReleaseYear());
                writer.append(",");
                writer.append(movie.getCreationDate());
                writer.append("\n");
            }
            System.out.println("Archivo CSV generado exitosamente en: " + filePath);

        }catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
