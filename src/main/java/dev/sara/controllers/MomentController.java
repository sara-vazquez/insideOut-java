package dev.sara.controllers;

import java.util.ArrayList;
import java.util.List;

import dev.sara.dtos.MomentDTO;
import dev.sara.dtos.MomentDTOResponse;
import dev.sara.mappers.MomentMapper;
import dev.sara.models.Moment;
import dev.sara.repositories.MomentRepository;
import dev.sara.singletons.MomentRepositorySingleton;
import dev.sara.views.MomentGetView;


public class MomentController {
    private MomentRepository repository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();
    }

    public void storeMoment(MomentDTO momentDTO) {
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.save(momentToSave);
        
    }

    public void getAllMoments() {
        List<MomentDTOResponse> momentsDTO = new ArrayList<>();
        List<Moment> moments = repository.getAllMoments();

        for (Moment moment : moments) {
            momentsDTO.add(new MomentDTOResponse(moment.getId(), moment.getMomentTitle(), moment.getMomentDescription(), moment.getEmotion(), moment.getMomentDate()));
        }

        MomentGetView.ViewAllMoments(momentsDTO);

    }
}
