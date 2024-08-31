package com.cakes.Service;

import com.cakes.DTO.GarnitureDto;
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


    @Override
    public GarnitureDto saveGarniture(GarnitureDto garnitureDto) {
        Garniture garniture = new Garniture();
        garniture.setIdTopping(garnitureDto.getIdTopping());
        garniture.setName(garnitureDto.getName());
        garniture.setPrice(garnitureDto.getPrice());
        garniture.setImage(garnitureDto.getImage());
        garnitureRepository.save(garniture);

        GarnitureDto savegarnitureDto = new GarnitureDto();
        savegarnitureDto.setIdTopping(garniture.getIdTopping());
        savegarnitureDto.setName(garniture.getName());
        savegarnitureDto.setPrice(garniture.getPrice());
        savegarnitureDto.setImage(garniture.getImage());
        return savegarnitureDto;

    }

    @Override
    public Optional<GarnitureDto> getGarnitureById(Long id) {

        Garniture Garniture = garnitureRepository.findById(id).orElse(null);
        if (Garniture != null) {
            GarnitureDto savegarnitureDto = new GarnitureDto();
            savegarnitureDto.setIdTopping(Garniture.getIdTopping());
            savegarnitureDto.setName(Garniture.getName());
            savegarnitureDto.setPrice(Garniture.getPrice());
            savegarnitureDto.setImage(Garniture.getImage());
            return Optional.of(savegarnitureDto);
        }
        return Optional.empty();
    }

    @Override
    public List<GarnitureDto> getAllGarnitures() {
        List<Garniture> garnitures = garnitureRepository.findAll();

        return garnitures.stream().map(garniture -> {
            GarnitureDto garnitureDto = new GarnitureDto();
            garnitureDto.setIdTopping(garniture.getIdTopping());
            garnitureDto.setName(garniture.getName());
            garnitureDto.setPrice(garniture.getPrice());
            garnitureDto.setImage(garniture.getImage());
            return garnitureDto;
        }).collect(Collectors.toList());
    }

    @Override
    public GarnitureDto updateGarniture(GarnitureDto garnitureDto, Long id) {

        Garniture Garniture  = garnitureRepository.findById(id).orElse(null);
        if (Garniture != null) {
           Garniture garnitur = new Garniture();
           garnitur.setIdTopping(garnitureDto.getIdTopping());
           garnitur.setName(garnitureDto.getName());
           garnitur.setPrice(garnitureDto.getPrice());
           garnitur.setImage(garnitureDto.getImage());
           garnitureRepository.save(garnitur);

           GarnitureDto savegarnitureDto = new GarnitureDto();
           savegarnitureDto.setIdTopping(Garniture.getIdTopping());
           savegarnitureDto.setName(garnitureDto.getName());
           savegarnitureDto.setPrice(garnitureDto.getPrice());
           savegarnitureDto.setImage(garnitureDto.getImage());
           return savegarnitureDto;
        }
        return null;
    }

    @Override
    public void deleteGarniture(Long id) {
        garnitureRepository.deleteById(id);
    }
}
