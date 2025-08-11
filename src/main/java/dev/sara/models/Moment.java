package dev.sara.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moment {

    private int id;
    private String momentTitle;
    private String momentDescription;
    private Emotion emotion;
    private LocalDate momentDate;
    private LocalDateTime creationDate;
    private LocalDateTime modDate;

    public Moment(String momentTitle, String momentDescription, Emotion emotion, LocalDate momentDate) {
        this.id = nextId++;
        this.momentTitle = momentTitle;
        this.momentDescription = momentDescription;
        this.emotion = emotion;
        this.momentDate = momentDate;

        this.creationDate = LocalDateTime.now();
        this.modDate = LocalDateTime.now();
    }

    //Getters

    public int getId() {
        return id;
    } 

    public String getMomentTitle() {
        return momentTitle;
    } 

    public String getMomentDescription() {
        return momentDescription;
    } 

    public Emotion getEmotion() {
        return emotion;
    } 

    public LocalDate getMomentDate() {
        return momentDate;
    } 

    public LocalDateTime getCreationDate() {
        return creationDate;
    } 

    public LocalDateTime getModDate() {
        return modDate;
    } 
}
