package dev.sara.views;

import java.util.List;

import dev.sara.dtos.MomentDTOResponse;

public class MomentGetView extends View {
    
    public static void ViewAllMoments(List<MomentDTOResponse> moments) {
        System.out.println("Lista de momentos vividos:");
        for (MomentDTOResponse moment : moments) {
            System.out.println(moment.id() + ". Ocurrió el: " + moment.momentDate() + ". Título: " + moment.momentTitle()+ ". Descripción: " + moment.momentDescription() + ". Emoción: " + moment.emotion());
        }
    }
}
