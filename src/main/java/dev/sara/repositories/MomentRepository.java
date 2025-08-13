package dev.sara.repositories;

import dev.sara.contracts.InterfaceDatabase;
import dev.sara.db.DiaryDatabase;
import dev.sara.models.Moment;

public class MomentRepository {

    private InterfaceDatabase db;

    public MomentRepository() {
        this.db = new DiaryDatabase();
    }
    
    public void StoreMoment(Moment moment) {

        db.store(moment);
    }

}
