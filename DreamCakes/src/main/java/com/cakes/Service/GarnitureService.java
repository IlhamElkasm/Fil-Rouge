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
    public List<GarnitureDto> getAllGarnitures() {
        List<Garniture> garnitures = garnitureRepository.findAll();
        return garnitureMapper.toDTOList(garnitures);
    }

    @Override
    public Optional<GarnitureDto> getGarnitureById(Long id) {
        Optional<Garniture> garniture = garnitureRepository.findById(id);
        return garniture.map(garnitureMapper::toDTO);
    }

    @Override
    public GarnitureDto updateGarniture(GarnitureDto garnitureDto, Long id) {
        Optional<Garniture> existingGarniture = garnitureRepository.findById(id);
        if (existingGarniture.isPresent()) {
            Garniture garniture = existingGarniture.get();

            // Do not update the ID, as it is the primary key and should not be changed
            garniture.setImage(garnitureDto.getImage());
            garniture.setName(garnitureDto.getName());
            garniture.setPrice(garnitureDto.getPrice());

            Garniture updatedGarniture = garnitureRepository.save(garniture);

            // Manually converting back to DTO
            GarnitureDto updatedGarnitureDto = new GarnitureDto();
            updatedGarnitureDto.setIdTopping(updatedGarniture.getIdTopping()); // Keep the original ID
            updatedGarnitureDto.setImage(updatedGarniture.getImage());
            updatedGarnitureDto.setName(updatedGarniture.getName());
            updatedGarnitureDto.setPrice(updatedGarniture.getPrice());

            return updatedGarnitureDto;
        }
        return null;
    }



    @Override
    public void deleteGarniture(Long id) {
        garnitureRepository.deleteById(id);
    }
}