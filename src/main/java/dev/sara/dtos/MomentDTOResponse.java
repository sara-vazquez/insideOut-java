package dev.sara.dtos;

import java.time.LocalDate;

import dev.sara.models.Emotion;

public record MomentDTOResponse(int id, String momentTitle, String momentDescription, Emotion emotion, LocalDate momentDate) {
    
}
