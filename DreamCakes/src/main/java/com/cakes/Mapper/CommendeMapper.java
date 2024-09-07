package com.cakes.Mapper;

import com.cakes.DTO.CommendeDto;
import com.cakes.Model.Commende;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommendeMapper {

    Commende toEntity(CommendeDto commendeDto);
    CommendeDto toDTO(Commende commende);
    List<CommendeDto> toDTOList(List<Commende> commendeList);
    List<Commende> toEntityList(List<CommendeDto> commendeDtoList);
}
