package dev.sara.views;

import dev.sara.models.Moment;
import dev.sara.repositories.MomentRepository;

public class HomeView extends View {

    public static void printMenu() {

        String text = """
                My diario:

                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Salir
                ----------------------
                Seleccione una opción:
                """;
        
        System.out.print(text);

        int option = SCANNER.nextInt();

       if (option == 1) {
        Moment newMoment = MomentPostView.createMoment();
       }
       if (option == 2) {
        List<Moment> moments = MomentRepository.getInstance().findAll();
       }
    }
    
}
