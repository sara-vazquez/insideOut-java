package dev.sara.views;

import dev.sara.singletons.MomentControllerSingleton;
import dev.sara.controllers.MomentController;

public class ExportView extends View {
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printExportMenu() {
        String exportText = """
            Exportar a CSV:
            Ingresa el nombre para el archivo CSV: 
                    """;
        
        System.out.println(exportText);
        SCANNER.nextLine();
        String fileName = SCANNER.nextLine();

        if(fileName.isEmpty()) {
            fileName = "diario.csv";
        }
        
        CONTROLLER.exportAllMoments(fileName);
        System.out.println("Exportación completada!");
    }
}
