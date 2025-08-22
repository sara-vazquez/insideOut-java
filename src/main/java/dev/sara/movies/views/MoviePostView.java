package dev.sara.movies.views;

import dev.sara.models.Emotion;
import dev.sara.movies.controllers.MovieController;
import dev.sara.movies.singletons.MovieControllerSingleton;
import dev.sara.views.HomeView;
import dev.sara.views.View;

public class MoviePostView extends View {
    
    private static MovieController getController() {
        return MovieControllerSingleton.getInstance();
    }

    public static void printStoreMovieMenu() {
        System.out.println("Añadir una nueva película");
        System.out.println("Ingrese el IMDB ID de la película (Ej.: tt0145487): ");
        String imdbId = SCANNER.next();

        System.out.println("\n Elige la emoción");
        for (Emotion emotion :  Emotion.values()) {
            System.out.println(emotion.ordinal() + 1 + ". " + emotion.name());
        }
        System.out.print("Seleccione la emoción: ");
        int emotionIndex = SCANNER.nextInt();
        SCANNER.nextLine();
        

        Emotion selectedEmotion = Emotion.values()[emotionIndex - 1];
        getController().addMovieById(imdbId, selectedEmotion);

        HomeView.printMenu();
    }
}
