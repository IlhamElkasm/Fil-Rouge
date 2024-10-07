package com.cakes.Mapper;

import com.cakes.DTO.FormDto;
import com.cakes.DTO.GateauDto;
import com.cakes.Model.Forme;
import com.cakes.Model.Gateau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GateauMapper {

    @Mapping(target = "forme.idShape", source = "idShape")
    @Mapping(target = "saveur.idFlavor", source = "idFlavor")
    @Mapping(target = "garnitures.idTopping", source = "idTopping")
    Gateau toEntity(GateauDto gateauDto);

    @Mapping(target = "idShape", source = "forme.idShape")
    @Mapping(target = "idFlavor", source = "saveur.idFlavor")
    @Mapping(target = "idTopping", source = "garnitures.idTopping")
    GateauDto toDTO(Gateau gateau);

    List<GateauDto> toDTOList(List<Gateau> gateauList);
    List<Gateau> toEntityList(List<GateauDto> gateauDtoList);
}

