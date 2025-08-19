package dev.sara.models;

public enum Mood {
    BUENO(1),
    MALO(2);

    private final int moodNumber;

    Mood(int moodNumber) {
        this.moodNumber = moodNumber;
    }
    
    public int getMoodNumber() {
        return moodNumber;
    }
}
