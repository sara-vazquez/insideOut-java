package dev.sara.views;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import dev.sara.controllers.MomentController;
import dev.sara.models.Moment;
import dev.sara.models.Mood;
import dev.sara.singletons.MomentControllerSingleton;

public class FilterMoodView extends View {
    
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static List<Moment> filterByMood() {
        System.out.print("Ingrese el mood: ");

        for (Mood m : Mood.values()) {
            System.out.println(m.getMoodNumber() + ". " + m.name());
        }

        int option = SCANNER.nextInt();
        SCANNER.nextLine();

        Mood selectedMood = null;
        for (Mood m : Mood.values()) {
            if(m.getMoodNumber() == option) {
                selectedMood = m;
                break;
            }
        }

        if (selectedMood == null) {
            System.out.println("Opción inválida");
            return Collections.emptyList();
        }

        List<Moment> filteredMoments = CONTROLLER.getMomentsByMood(selectedMood);

        if (filteredMoments.isEmpty()) {
            System.out.println("No hay momentos con ese mood.");
        } else {
            System.out.println("Lista de momentos vividos:");
            for (Moment m : filteredMoments) {
                String formattedDate = m.getMomentDate().format(FORMATTER);
                System.out.println(m.getId() + ". Ocurrió el: " + formattedDate + ". Título:" + m.getMomentTitle() + ". Descripción: " + m.getMomentDescription() + ". Emocion:" + m.getEmotion()+ ". Mood:" + m.getMood());
            }
        }

        return filteredMoments;
    }
}
