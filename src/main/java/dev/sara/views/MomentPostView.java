package dev.sara.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dev.sara.controllers.MomentController;
import dev.sara.dtos.MomentDTO;
import dev.sara.models.Emotion;
import dev.sara.singletons.MomentControllerSingleton;

public class MomentPostView extends View {
    
    private static MomentController getController() {
        return MomentControllerSingleton.getInstance();
    }

    public static  void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String momentTitle = SCANNER.next();
       
        LocalDate momentDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do { 
            System.out.println("Ingresa la fecha (dd/mm/year):");
            String momentDateStr = SCANNER.next();       
            
            try {
                momentDate = LocalDate.parse(momentDateStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");            
            }
        
        } while (momentDate == null);
        
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
        //SCANNER.nextLine();

        Emotion emotion = Emotion.values()[emotionNumber - 1];
        MomentDTO moment = new MomentDTO(1, momentTitle, momentDescription, emotion, momentDate);
        getController().storeMoment(moment);
        
        System.out.println("Momento añadido con éxito.");
        HomeView.printMenu();
    }
    
    
}
