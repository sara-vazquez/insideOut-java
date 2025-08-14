package dev.sara.models;

public enum Emotion {
    ALEGRIA(1),
    TRISTEZA(2),
    IRA(3),
    ASCO(4),
    MIEDO(5),
    ANSIEDAD(6),
    ENVIDIA(7),
    VERGUENZA(8),
    ABURRIMIENTO(9),
    NOSTALGIA(10);

    private final int emotionNumber;

    Emotion(int emotionNumber) {
        this.emotionNumber = emotionNumber;
    }
    
    public int getEmotionNumber() {
        return emotionNumber;
    }

}
