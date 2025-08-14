package dev.sara.contracts;

import java.util.List;

public interface InterfaceDatabase<E> {
    public void store(E element);
    List<E> getAll();

   public void deleteMoment(int id);
}
