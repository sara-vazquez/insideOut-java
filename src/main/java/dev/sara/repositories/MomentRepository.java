package dev.sara.repositories;

import dev.sara.db.*;

public class MomentRepository {

    private InterfaceDatabase db;

    public MomentRepository() {
        this.db = new DiaryDatabase();
    }
    
    public void StoreMoment(Moment moment) {

        db.store(moment);
    }

}
