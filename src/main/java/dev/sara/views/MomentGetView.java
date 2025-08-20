package dev.sara.views;

import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.sara.dtos.MomentDTOResponse;

public class MomentGetView extends View {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
    public static void viewAllMoments(List<MomentDTOResponse> moments) {
        System.out.println("Lista de momentos vividos:");


        if(moments.isEmpty()) {
            System.out.println("Aún no tienes momentos registrados.");
        } else { 
            for (MomentDTOResponse moment : moments) {
        
                String formattedDate = moment.momentDate().format(FORMATTER);
                System.out.println(moment.id() + ". Ocurrió el: " + formattedDate + ". Título: " + moment.momentTitle()+ ". Descripción: " + moment.momentDescription() + ". Emoción: " + moment.emotion() + ". Mood: " + moment.mood());
            }
        }
        HomeView.printMenu();
    }
}
