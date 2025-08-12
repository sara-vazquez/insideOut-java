package dev.sara.singletons;

import dev.sara.repositories.MomentRepository;

public class MomentRepositorySingleton {
    
    private static MomentRepository INSTANCE;

    private MomentRepositorySingleton() {}

    public static MomentRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MomentRepository();
        }
        return INSTANCE;
    }
}
