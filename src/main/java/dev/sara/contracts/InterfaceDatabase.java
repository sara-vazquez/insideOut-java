package dev.sara.contracts;

import java.util.List;

import dev.sara.models.Moment;

public interface InterfaceDatabase {
    public void store(Moment moment);
    public List<Moment> getAll();
}
