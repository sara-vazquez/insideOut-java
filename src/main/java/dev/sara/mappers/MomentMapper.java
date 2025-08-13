package dev.sara.mappers;

import dev.sara.dtos.MomentDTO;
import dev.sara.models.Moment;

public class MomentMapper {
    public static Moment toEntity(MomentDTO dto) {

    return new Moment(dto.momentTitle(), dto.momentDescription(), dto.emotion(), dto.momentDate());
    }

    public static MomentDTO toDTO(Moment moment) {
        return new MomentDTO(
            moment.getId(),
            moment.getMomentTitle(),
            moment.getMomentDescription(),
            moment.getEmotion(),
            moment.getMomentDate()
        );
    }
}
