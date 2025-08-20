package dev.sara.views;

//import dev.sara.controllers.MomentController;
//import dev.sara.singletons.MomentControllerSingleton;

public class FilterView extends View {

   // private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {
        String text = """
            Filtrar por...
            1. Emoción
            2. Fecha
            3. Mood
            "Ingrese una opción: "
            """;
    
    System.out.print(text);
    int option = SCANNER.nextInt();

    if (option == 1) FilterEmotionView.filterByEmotion();
    if (option == 2) FilterDateView.filterByDate();
    if (option == 3) FilterMoodView.filterByMood();

    HomeView.printMenu();
   
}

}
