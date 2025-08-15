package dev.sara.views;

import dev.sara.models.*;
import dev.sara.controllers.*;
import dev.sara.singletons.MomentControllerSingleton;
import java.util.List;
import java.util.Collections;


public class FilterEmotionView extends View {

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static List<Moment> filterByEmotion() {
        System.out.print("Seleccione una emoción: ");

        for (Emotion e : Emotion.values()) {
            System.out.println(e.getEmotionNumber() + ". " + e.name());
        }

        int option = SCANNER.nextInt();
        SCANNER.nextLine();

        for (Emotion e : Emotion.values()) {
            if(e.getEmotionNumber() == option) {
                selectedEmotion == e;
                break;
            }
        }

        if (selectedEmotion == null) {
            System.out.println("Opción inválida");
            return Collections.emptyList();
        }

        List<Moment> filteredMoments = CONTROLLER.getMomentsByEmotion(selectedEmotion);

        if (filteredMoments.isEmpty()) {
            System.out.println("No hay momentos con esa emoción.");
        } else {
            System.out.println("Lista de momentos vividos:");
            for (Moment m : filteredMoments) {
                System.out.println(m.getId() + ". Ocurrió el: " + m.getMomentDate() + ". Título:" + m.getMomentTitle() + ". Descripción: " + m.getMomentDescription() + ". Emocion:" + m.getEmotion());
            }
        }

        return filteredMoments;
    }
   
}
