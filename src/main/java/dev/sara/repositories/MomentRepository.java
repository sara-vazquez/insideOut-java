package dev.sara.repositories;

import dev.sara.db.*;
import dev.sara.contracts.*;
import dev.sara.models.*;

public class MomentRepository {

    private InterfaceDatabase db;

    public MomentRepository() {
        this.db = new DiaryDatabaseTest();
    }
    
    public void StoreMoment(Moment moment) {

        db.store(moment);
    }

}
