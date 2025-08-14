package dev.sara.views;

public class MomentDeleteView extends View {
    
    public static void printDeleteMoment() {
        System.out.println("Ingrese el identificador del momento: ");
        int id = SCANNER.nextInt();

        System.out.println("Momento vivido eliminado correctamente");
        HomeView.printMenu();
    }
}
