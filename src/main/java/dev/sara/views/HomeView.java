package dev.sara.views;

import dev.sara.controllers.MomentController;
import dev.sara.movies.views.MoviePostView;
import dev.sara.singletons.MomentControllerSingleton;

public class HomeView extends View {

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printMenu() {

        String text = """
                My diario:

                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Exportar a CSV
                6. Añadir película
                7. Salir
                ----------------------
                Seleccione una opción:
                """;
        
        System.out.print(text);

        int option = SCANNER.nextInt();

       if (option == 1) MomentPostView.printStoreMenu();
    
       if (option == 2) CONTROLLER.getAllMoments();

       if (option == 3) MomentDeleteView.printDeleteMoment();

       if (option == 4) FilterView.printFilterMenu();

       if (option == 5) MomentExportView.printExportMenu();

       if (option == 6) MoviePostView.printStoreMovieMenu();

       if (option == 7) System.out.println("¡Hasta la próxima! 👋");
       
    }
    
}
