package com.cakes.Service;

import com.cakes.DTO.FormDto;
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

    // Save Forme
    public FormDto saveForme(FormDto formDto) {
        // Direct mapping between DTO and Entity
        Forme forme = new Forme();
        forme.setIdShape(formDto.getIdShape());
        forme.setImage(formDto.getImage());
        forme.setName(formDto.getName());
        forme.setDimensions(formDto.getDimensions());
        forme.setPrice(formDto.getPrice());

        Forme savedForme = formeRepository.save(forme);

        // Set the ID returned by the database
        formDto.setIdShape(savedForme.getIdShape());
        return formDto;
    }

    // Get Forme by ID
    public Optional<FormDto> getFormeById(Long id) {
        Optional<Forme> forme = formeRepository.findById(id);

        if (forme.isPresent()) {
            Forme existingForme = forme.get();
            // Directly return DTO
            return Optional.of(new FormDto(
                    existingForme.getIdShape(),
                    existingForme.getImage(),
                    existingForme.getName(),
                    existingForme.getDimensions(),
                    existingForme.getPrice()
            ));
        }

        return Optional.empty();
    }

    // Get all Formes
    public List<FormDto> getAllFormes() {
        List<Forme> formes = formeRepository.findAll();
        // Directly map each Forme to FormDto
        return formes.stream()
                .map(forme -> new FormDto(
                        forme.getIdShape(),
                        forme.getImage(),
                        forme.getName(),
                        forme.getDimensions(),
                        forme.getPrice()
                ))
                .toList();
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
            forme.setImage(formDto.getImage());
            forme.setName(formDto.getName());
            forme.setDimensions(formDto.getDimensions());
            forme.setPrice(formDto.getPrice());

            Forme updatedForme = formeRepository.save(forme);
            // Directly return updated FormDto
            return Optional.of(formDto);
        }
        return Optional.empty();
    }
}