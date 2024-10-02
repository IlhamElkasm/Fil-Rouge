package com.cakes.Service;

import com.cakes.DTO.FormDto;
import com.cakes.Mapper.FormMapper;
import com.cakes.Model.Forme;
import com.cakes.Repository.FormeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormeService implements IFormeService {

    @Autowired
    private FormeRepository formeRepository;

    @Autowired
    private FormMapper formMapper;

    // Save Forme
    public FormDto saveForme(FormDto formDto) {
        // Use the mapper to convert DTO to Entity
        Forme forme = formMapper.toEntity(formDto);
        Forme savedForme = formeRepository.save(forme);
        return formMapper.toDTO(savedForme);
    }

    // Get Forme by ID
    public Optional<FormDto> getFormeById(Long id) {
        Optional<Forme> forme = formeRepository.findById(id);
        return forme.map(formMapper::toDTO);
    }

    // Get all Formes
    public List<FormDto> getAllFormes() {
        List<Forme> formes = formeRepository.findAll();
        return formMapper.toDTOList(formes);
    }

    // Delete Forme
    public void deleteForme(Long id) {
        formeRepository.deleteById(id);
    }

    // Update Forme
    public Optional<FormDto> updateForme(Long id, FormDto formDto) {
        Optional<Forme> existingForme = formeRepository.findById(id);
        if (existingForme.isPresent()) {
            Forme forme = existingForme.get();

            // Manually update the entity with the new data from the DTO
            forme.setImage(formDto.getImage());
            forme.setName(formDto.getName());
            forme.setDimensions(formDto.getDimensions());
            forme.setPrice(formDto.getPrice());

            // Save the updated entity
            Forme updatedForme = formeRepository.save(forme);

            // Manually create a new FormDto from the updated entity
            FormDto updatedFormDto = new FormDto();
            updatedFormDto.setIdShape(updatedForme.getIdShape());
            updatedFormDto.setImage(updatedForme.getImage());
            updatedFormDto.setName(updatedForme.getName());
            updatedFormDto.setDimensions(updatedForme.getDimensions());
            updatedFormDto.setPrice(updatedForme.getPrice());

            return Optional.of(updatedFormDto);
        }
        return Optional.empty();
    }

}