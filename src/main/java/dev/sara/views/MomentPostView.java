package dev.sara.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dev.sara.controllers.MomentController;
import dev.sara.models.Emotion;
import dev.sara.models.Moment;
import dev.sara.singletons.MomentControllerSingleton;

public class MomentPostView extends View {
    
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printStoreMenu() {
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
        SCANNER.next();

        Emotion emotion = Emotion.getEmotionByNumber(emotionNumber);
        Moment newMoment = new Moment(momentTitle, momentDescription, emotion, momentDate);


        System.out.println("--- Lista de momentos vividos ---");
        System.out.printf("%d. Ocurrió el: %s. Título: %s. Descripción: %s. Emoción: %s%n",
                          newMoment.getId(),
                          newMoment.getMomentDate().format(formatter),
                          newMoment.getMomentTitle(),
                          newMoment.getMomentDescription(),
                          newMoment.getEmotion().name());

                       // return newMoment;
    }
}
