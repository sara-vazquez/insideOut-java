package dev.sara.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque; //para poder hacer LIFO
import java.util.LinkedList;
import java.util.List;

import dev.sara.contracts.InterfaceDatabase;
import dev.sara.db.DiaryDatabase; 
import dev.sara.models.Emotion;
import dev.sara.models.Moment;
import dev.sara.models.Mood;
import dev.sara.singletons.MomentRepositorySingleton;

public class MomentRepository {

    private final InterfaceDatabase<Moment> db;
    private final Deque<Moment> momentStore = new LinkedList<>();

    public MomentRepository() {
        this.db = new DiaryDatabase();
    }

    public static MomentRepository getInstance() {
        return MomentRepositorySingleton.getInstance();
    }

    public void save(Moment moment) {
        db.store(moment);
        momentStore.push(moment);
    }
    
    public List<Moment> getAllMoments() {
        List<Moment> moments = new ArrayList<>(db.getAll());
        Collections.reverse(moments); //aquí actua LIFO mirar Stack
        return moments;
    }

   public Moment findLast() {
        if (momentStore.isEmpty()) {
            return null;
        }
        return momentStore.peek(); //para ver el último momento añadido
    }
    
    public Moment delete() {
        if (momentStore.isEmpty()) {
            return null;
        }
        return momentStore.pop();
    }

   public void deleteMoment(int id) {
        db.deleteMoment(id);
    } 

    public List<Moment> filterByEmotion(Emotion emotion) {
        return db.filterByEmotion(emotion);
    }

    public List<Moment> filterByDate(int month, int year) {
        return db.filterByDate(month, year);
    }

    public List<Moment> filterByMood(Mood mood) {
        return db.filterByMood(mood);
    }
}
