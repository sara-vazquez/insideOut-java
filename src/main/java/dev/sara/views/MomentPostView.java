package dev.sara.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MomentPostView extends View {
    
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String momentTitle = SCANNER.next();
       
        System.out.println("Ingresa la fecha (dd/mm/year):");
        String momentDate = SCANNER.next();        
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date inputDate = inputFormat.parse(momentDate);
            System.out.println("String to Date: " + inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        System.out.println("Ingrese la descripción:");
        String momentDescription = SCANNER.next();

        String text = """
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
        
        System.out.print(text);

        int emotionNumber = SCANNER.nextInt();
        
       
    }
}