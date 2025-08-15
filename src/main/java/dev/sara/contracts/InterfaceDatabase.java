package dev.sara.contracts;

import java.util.List;

import dev.sara.models.Emotion;
import dev.sara.models.Moment;

public interface InterfaceDatabase<E> {
    public void store(E element);
    List<E> getAll();

   public void deleteMoment(int id);
   List<Moment> filterByEmotion(Emotion emotion);
}
