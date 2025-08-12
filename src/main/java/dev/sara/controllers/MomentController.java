package dev.sara.controllers;

import dev.sara.models.*;
import dev.sara.repositories.*;
import dev.sara.singletons.*;

public class MomentController {
    private MomentRepository repository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();
    }

    public void StoreMoment(MomentDTO momentDTO) {
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.StoreMoment(momentToSave);
    }
}
