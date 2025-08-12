package dev.sara.mappers;

import dev.sara.dtos.MomentDTO;
import dev.sara.models.Moment;

public class MomentMapper {
    public static Moment toEntity(MomentDTO dto) {

        //falta el id
        Moment moment = new Moment(dto.momentTitle(), dto.momentDescription(), dto.emotion(), dto.momentDate());
        return moment;
    }
}
