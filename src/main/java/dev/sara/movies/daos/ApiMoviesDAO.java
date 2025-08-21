package dev.sara.movies.daos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class ApiMoviesDAO implements InterfaceApiMovieDAO {

    @Override
    public String getMovie(String imdbId) {

        String fullUrl = "https://imdb.iamidiotareyoutoo.com/search?tt=" + imdbId;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
                    .build()
                    .sendAsync(request, BodyHandlers.ofString());
            return response.get().body();
        } catch (Exception e) {
            return e.getMessage();
        }

        /*
         * client.sendAsync(request, BodyHandlers.ofString())
         * .thenApply(HttpResponse::body)
         * .thenAccept(System.out::println)
         * .join();
         */

    }

    
}
