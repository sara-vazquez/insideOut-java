package dev.sara.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import dev.sara.models.Moment;



public class MomentCSV {

    public static exportMomentCSV(List<Moment> moments, String fileRoute) {

        try (FileWriter writer = new FileWriter(null)) {
            writer.append("Fecha,Titulo,Descripción,Emoción,Mood\n");

            for(Moment moment : moments) {
                writer.append(moment.getMomentDate().toString());
                writer.append(",");
                writer.append(moment.getMomentTitle());
                writer.append(",");
                writer.append(moment.getMomentDescription());
                writer.append(moment.getEmotion());
                writer.append(",");
                writer.append(moment.getMood());
                writer.append("\n");
            }
            System.out.println("Archivo CSV generado exitosamente en: " + fileRoute);

        }catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
    
}
