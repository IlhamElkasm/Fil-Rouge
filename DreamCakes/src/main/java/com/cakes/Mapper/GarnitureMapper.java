package com.cakes.Mapper;

import com.cakes.DTO.FormDto;
import com.cakes.DTO.GarnitureDto;
import com.cakes.Model.Forme;
import com.cakes.Model.Garniture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GarnitureMapper {

    Garniture toEntity(GarnitureDto garnitureDto);
    GarnitureDto toDTO(Garniture garniture);
    List<GarnitureDto> toDTOList(List<Garniture> garnitureList);
    List<Garniture> toEntityList(List<GarnitureDto> garnitureDtoList);
}
