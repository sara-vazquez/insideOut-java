package dev.sara.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moment {

    private static int nextId = 1;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMomentTitle() {
        return momentTitle;
    }

    public void setMomentTitle(String momentTitle) {
        this.momentTitle = momentTitle;
    }

    public String getMomentDescription() {
        return momentDescription;
    }

    public void setMomentDescription(String momentDescription) {
        this.momentDescription = momentDescription;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public LocalDate getMomentDate() {
        return momentDate;
    }

    public void setMomentDate(LocalDate momentDate) {
        this.momentDate = momentDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModDate() {
        return modDate;
    }

    public void setModDate(LocalDateTime modDate) {
        this.modDate = modDate;
    }
     
}
