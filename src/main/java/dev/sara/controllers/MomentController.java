package dev.sara.controllers;

import dev.sara.dtos.MomentDTO;
import dev.sara.mappers.MomentMapper;
import dev.sara.models.Moment;
import dev.sara.repositories.MomentRepository;
import dev.sara.singletons.MomentRepositorySingleton;


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
