package dev.sara.contracts;

import java.util.List;

import dev.sara.models.Emotion;

public interface InterfaceDatabase<T> {
    public void store(T t);
    List<T> getAll();

   public void deleteMoment(int id);
   List<T> filterByEmotion(Emotion emotion);
   List<T> filterByDate(int month, int year);
}
