package dev.sara.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import dev.sara.models.Moment;



public class MomentCSV {

    public static void exportMomentCSV(List<Moment> moments, String fileRoute) {

        try (FileWriter writer = new FileWriter(fileRoute)) {
            writer.append("Fecha,Titulo,Descripción,Emoción,Mood\n");

            for(Moment moment : moments) {
                writer.append(moment.getMomentDate().toString());
                writer.append(",");
                writer.append(moment.getMomentTitle());
                writer.append(",");
                writer.append(moment.getMomentDescription());
                writer.append(",");
                writer.append(moment.getEmotion().name());
                writer.append(",");
                writer.append(moment.getMood().name());
                writer.append("\n");
            }
            System.out.println("Archivo CSV generado exitosamente en: " + fileRoute);

        }catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
    
}
