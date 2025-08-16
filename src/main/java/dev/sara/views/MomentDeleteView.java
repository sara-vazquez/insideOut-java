package dev.sara.views;

import dev.sara.controllers.MomentController;
import dev.sara.singletons.MomentControllerSingleton;

public class MomentDeleteView extends View {

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    
    public static void printDeleteMoment() {
        System.out.println("Ingrese el identificador del momento: ");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        CONTROLLER.deleteMoment(id);
        System.out.println("Momento vivido eliminado correctamente");
        HomeView.printMenu();
    }
}
