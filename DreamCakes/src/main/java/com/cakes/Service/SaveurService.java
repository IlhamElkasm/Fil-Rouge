package com.cakes.Service;

import com.cakes.DTO.SaveurDto;
import com.cakes.Mapper.SaveurMapper;
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

    @Autowired
    private SaveurMapper saveurMapper;

    @Override
    public SaveurDto saveSaveur(SaveurDto saveurDto) {
        // Use the mapper to convert DTO to Entity
        Saveur saveur = saveurMapper.toEntity(saveurDto);
        Saveur savedSaveur = saveurRepository.save(saveur);
        return saveurMapper.toDTO(savedSaveur);
    }

    @Override
    public Optional<SaveurDto> getSaveurById(Long id) {
        Optional<Saveur> saveur = saveurRepository.findById(id);
        return saveur.map(saveurMapper::toDTO);
    }

    @Override
    public List<SaveurDto> getAllSaveurs() {
        List<Saveur> saveurs = saveurRepository.findAll();
        return saveurMapper.toDTOList(saveurs);
    }

    @Override
    public SaveurDto updateSaveur(Long id, SaveurDto saveurDto) {
        Optional<Saveur> existingSaveur = saveurRepository.findById(id);

        if (existingSaveur.isPresent()) {
            Saveur saveur = existingSaveur.get();
            saveurMapper.toEntity(saveurDto); // Update existing entity with DTO data
            Saveur updatedSaveur = saveurRepository.save(saveur);
            return saveurMapper.toDTO(updatedSaveur);
        }

        return null; // or throw an exception if not found
    }

    @Override
    public void deleteSaveur(Long id) {
        saveurRepository.deleteById(id);
    }
}