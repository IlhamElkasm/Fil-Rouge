package com.cakes.Service;

import com.cakes.DTO.GarnitureDto;
import com.cakes.Model.Garniture;

import java.util.List;
import java.util.Optional;

public interface IGarnitureService {

    GarnitureDto saveGarniture(GarnitureDto garnitureDto);
    Optional<GarnitureDto> getGarnitureById(Long id);
    List<GarnitureDto> getAllGarnitures();
    GarnitureDto updateGarniture(GarnitureDto garnitureDto, Long id);
    void deleteGarniture(Long id);
}
