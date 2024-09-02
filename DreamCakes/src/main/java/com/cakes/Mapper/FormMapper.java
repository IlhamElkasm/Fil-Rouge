package com.cakes.Mapper;

import com.cakes.DTO.FormDto;
import com.cakes.Model.Forme;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FormMapper {

    Forme toEntity(FormDto formDto);
    FormDto toDTO(Forme forme);
    List<FormDto> toDTOList(List<Forme> formeList);
    List<Forme> toEntityList(List<FormDto> formDtoList);
}
