package com.cakes.Mapper;

import com.cakes.DTO.SaveurDto;
import com.cakes.Model.Saveur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaveurMapper {

    Saveur toEntity(SaveurDto saveurDto);
    SaveurDto toDTO(Saveur saveur);
    List<SaveurDto> toDTOList(List<Saveur> saveurList);
    List<Saveur> toEntityList(List<SaveurDto> saveurDtoList);
}
