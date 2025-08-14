package dev.sara.views;

import dev.sara.models.*;
import dev.sara.controllers.*;
import dev.sara.singletons.*;
import dev.sara.views.*;


public class FilterEmotionView extends View {

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {
        Scanner scanner = new Scanner(System.in);

        String filterEmotion = """
           Selecciona una emoción:
            1. Alegría
            2. Tristeza
            3. Ira
            4. Asco
            5. Miedo
            6. Ansiedad
            7. Envidia
            8. Vergüenza
            9. Aburrimiento
            10. Nostalgia
            Ingrese su opción:
             """;

        System.out.println(filterEmotion);
        int option = scanner.nextInt();
    }

    

   
}
