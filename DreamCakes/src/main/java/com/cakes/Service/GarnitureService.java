package com.cakes.Service;

import com.cakes.DTO.GarnitureDto;
import com.cakes.Mapper.GarnitureMapper;
import com.cakes.Model.Garniture;
import com.cakes.Repository.GarnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GarnitureService implements IGarnitureService {

    @Autowired
    private GarnitureRepository garnitureRepository;

    @Autowired
    private GarnitureMapper garnitureMapper;

    @Override
    public GarnitureDto saveGarniture(GarnitureDto garnitureDto) {
        // Use the mapper to convert DTO to Entity
        Garniture garniture = garnitureMapper.toEntity(garnitureDto);
        Garniture savedGarniture = garnitureRepository.save(garniture);
        return garnitureMapper.toDTO(savedGarniture);
    }

    @Override
    public Optional<GarnitureDto> getGarnitureById(Long id) {
        Optional<Garniture> garniture = garnitureRepository.findById(id);
        return garniture.map(garnitureMapper::toDTO);
    }

    @Override
    public List<GarnitureDto> getAllGarnitures() {
        List<Garniture> garnitures = garnitureRepository.findAll();
        return garnitureMapper.toDTOList(garnitures);
    }

    @Override
    public GarnitureDto updateGarniture(GarnitureDto garnitureDto, Long id) {
        Optional<Garniture> existingGarniture = garnitureRepository.findById(id);
        if (existingGarniture.isPresent()) {
            Garniture garniture = existingGarniture.get();
            garnitureMapper.toEntity(garnitureDto); // Updating the existing entity with DTO data
            Garniture updatedGarniture = garnitureRepository.save(garniture);
            return garnitureMapper.toDTO(updatedGarniture);
        }
        return null;
    }

    @Override
    public void deleteGarniture(Long id) {
        garnitureRepository.deleteById(id);
    }
}