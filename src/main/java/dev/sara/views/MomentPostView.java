package dev.sara.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MomentPostView extends View {
    
    //private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String momentTitle = SCANNER.next();
       
        System.out.println("Ingresa la fecha (dd/mm/year):");
        String momentDate = SCANNER.next();        
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date inputDate = inputFormat.parse(momentDate);
            System.out.println("String to Date: " + inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        System.out.println("Ingrese la descripción:");
        String momentDescription = SCANNER.next();
        
       
    }
}