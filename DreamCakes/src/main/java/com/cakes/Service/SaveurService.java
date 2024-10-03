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
    public List<SaveurDto> getAllSaveurs() {
        List<Saveur> saveurs = saveurRepository.findAll();
        return saveurMapper.toDTOList(saveurs);
    }

    @Override
    public Optional<SaveurDto> getSaveurById(Long id) {
        Optional<Saveur> saveur = saveurRepository.findById(id);
        return saveur.map(saveurMapper::toDTO);
    }

    @Override
    public SaveurDto updateSaveur(Long id, SaveurDto saveurDto) {
        Optional<Saveur> existingSaveurOpt = saveurRepository.findById(id);

        if (existingSaveurOpt.isPresent()) {
            Saveur existingSaveur = existingSaveurOpt.get();

            // Update fields manually from the DTO to the entity
            existingSaveur.setName(saveurDto.getName());
            existingSaveur.setPrice(saveurDto.getPrice());
            existingSaveur.setImage(saveurDto.getImage());

            // Save the updated entity
            Saveur updatedSaveur = saveurRepository.save(existingSaveur);

            // Return the updated Saveur as a DTO
            return saveurMapper.toDTO(updatedSaveur);
        }

        return null; // or you can throw an exception, such as ResourceNotFoundException
    }


    @Override
    public void deleteSaveur(Long id) {
        saveurRepository.deleteById(id);
    }
}