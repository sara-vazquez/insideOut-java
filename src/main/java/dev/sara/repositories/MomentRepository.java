package dev.sara.repositories;

import dev.sara.db.*;
import dev.sara.contracts.*;
import dev.sara.singletons.*;
import dev.sara.models.*;
import java.util.Deque; //para poder hacer LIFO
import java.util.LinkedList;
import java.util.List;

public class MomentRepository {

    private InterfaceDatabase db;
    private final Deque<Moment> momentStore = new LinkedList<>();

    private MomentRepository() {
        this.db = new DiaryDatabase();
    }

    public static MomentRepository getInstance() {
        return MomentRepositorySingleton.getInstance();
    }

    public void save(Moment moment) {
        db.store(moment);
        momentStore.push(moment);
    }
    
    public List<Moment> findAll() {
        return (List<Moment>) momentStore;
    }

    public Moment findLast() {
        if (momentStore.isEmpty()) {
            return null;
        }
        return momentStore.peek(); //para ver el último momento añadido
    }
    
    public Moment deleteLast() {
        if (momentStore.isEmpty()) {
            return null;
        }
        return momentStore.pop();
    }

}
