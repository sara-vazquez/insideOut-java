package dev.sara.dtos;

import java.time.LocalDate;

import dev.sara.models.Emotion;
import dev.sara.models.Mood;

public record MomentDTO(int id, String momentTitle, String momentDescription, Emotion emotion, LocalDate momentDate, Mood mood) {

}
