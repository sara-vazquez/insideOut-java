package dev.sara.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dev.sara.controllers.MomentController;
import dev.sara.singletons.MomentControllerSingleton;

public class MomentPostView extends View {
    
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String momentTitle = SCANNER.next();
       
        Date inputDate = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        inputFormat.setLenient(false); //validación estricta de la fecha

        do { 
            System.out.println("Ingresa la fecha (dd/mm/year):");
            String momentDate = SCANNER.next();       
            
            try {
                inputDate = inputFormat.parse(momentDate);
            } catch (ParseException e) {
                System.out.println("⚠️ Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");            }
        } while (inputDate == null);

        System.out.println("Fecha validada: " + inputDate);
        
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
        
       SCANNER.next();
    }
}
