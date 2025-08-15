package dev.sara.views;

import java.util.List;

import dev.sara.controllers.MomentController;
import dev.sara.models.Moment;
import dev.sara.singletons.MomentControllerSingleton;

public class FilterDateView extends View {
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static List<Moment> filterByDate() {
        System.out.print("Ingresa el mes: ");
        int month = SCANNER.nextInt();

        System.out.print("Ingresa el año: ");
        int year = SCANNER.nextInt();

        List<Moment> filteredMoments = CONTROLLER.getMomentsByDate(month, year);

        if (filteredMoments.isEmpty()) {
            System.out.println("No hay momentos con esa fecha.");
        } else {
            System.out.println("Lista de momentos vividos:");
            for (Moment m : filteredMoments) {
                System.out.println(m.getId() + ". Ocurrió el: " + m.getMomentDate() + ". Título:" + m.getMomentTitle() + ". Descripción: " + m.getMomentDescription() + ". Emocion:" + m.getEmotion());
            }
        }
        return filteredMoments;
    }

}
