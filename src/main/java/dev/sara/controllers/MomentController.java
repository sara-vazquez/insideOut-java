package dev.sara.controllers;

import dev.sara.dtos.MomentDTO;
import dev.sara.mappers.MomentMapper;
import dev.sara.models.Moment;
import dev.sara.repositories.MomentRepository;
import dev.sara.singletons.MomentRepositorySingleton;
import dev.sara.views.*;

import java.util.List;


public class MomentController {
    private static MomentRepository REPOSITORY = MomentRepositorySingleton.getInstance();

    public static void addMoment() {
        MomentDTO newMomentDTO = MomentPostView.getMomentData();
        Moment momentToSave = MomentMapper.toEntity(newMomentDTO);
        REPOSITORY.save(momentToSave);
        System.out.println("✅ Momento añadido con éxito.");
    }

    public void ViewAllMoments() {
        List<Moment> moments = REPOSITORY.findAll();
        List<MomentDTO> momentsDTO = MomentMapper.toDTOList(moments);
        HomeView.printMomentList(momentsDTO);
    }
}
