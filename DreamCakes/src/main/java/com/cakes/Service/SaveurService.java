package com.cakes.Service;

import com.cakes.DTO.SaveurDto;
import com.cakes.Model.Saveur;
import com.cakes.Repository.SaveurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaveurService implements ISaveurService {

    @Autowired
    private SaveurRepository saveurRepository;

    @Override
    public SaveurDto saveSaveur(SaveurDto saveurDto) {
        Saveur saveur = new Saveur();
        saveur.setIdFlavor(saveurDto.getIdFlavor());
        saveur.setImage(saveurDto.getImage());
        saveur.setName(saveurDto.getName());
        saveur.setPrice(saveurDto.getPrice());
        Saveur savedSaveur = saveurRepository.save(saveur);

        SaveurDto savedSaveurDto = new SaveurDto();
        savedSaveurDto.setIdFlavor(savedSaveur.getIdFlavor());
        savedSaveurDto.setImage(savedSaveur.getImage());
        savedSaveurDto.setName(savedSaveur.getName());
        savedSaveurDto.setPrice(savedSaveur.getPrice());
        return savedSaveurDto;
    }

    @Override
    public Optional<SaveurDto> getSaveurById(Long id) {
        Optional<Saveur> saveur = saveurRepository.findById(id);
        if (saveur.isPresent()) {
            Saveur saveurEntity = saveur.get();
            SaveurDto saveurDto = new SaveurDto();
            saveurDto.setIdFlavor(saveurEntity.getIdFlavor());
            saveurDto.setImage(saveurEntity.getImage());
            saveurDto.setName(saveurEntity.getName());
            saveurDto.setPrice(saveurEntity.getPrice());
            return Optional.of(saveurDto);
        }
        return Optional.empty();
    }

    @Override
    public List<SaveurDto> getAllSaveurs() {
        List<Saveur> saveurs = saveurRepository.findAll();
        return saveurs.stream().map(saveur -> {
            SaveurDto dto = new SaveurDto();
            dto.setIdFlavor(saveur.getIdFlavor());
            dto.setImage(saveur.getImage());
            dto.setName(saveur.getName());
            dto.setPrice(saveur.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public SaveurDto updateSaveur(Long id, SaveurDto saveurDto) {
        Optional<Saveur> existingSaveur = saveurRepository.findById(id);

        if (existingSaveur.isPresent()) {
            Saveur saveur = existingSaveur.get();
            saveur.setImage(saveurDto.getImage());
            saveur.setName(saveurDto.getName());
            saveur.setPrice(saveurDto.getPrice());
            Saveur updatedSaveur = saveurRepository.save(saveur);

            SaveurDto updatedSaveurDto = new SaveurDto();
            updatedSaveurDto.setIdFlavor(updatedSaveur.getIdFlavor());
            updatedSaveurDto.setImage(updatedSaveur.getImage());
            updatedSaveurDto.setName(updatedSaveur.getName());
            updatedSaveurDto.setPrice(updatedSaveur.getPrice());
            return updatedSaveurDto;
        }

        return null; // or throw an exception if not found
    }

    @Override
    public void deleteSaveur(Long id) {
        saveurRepository.deleteById(id);
    }
}
