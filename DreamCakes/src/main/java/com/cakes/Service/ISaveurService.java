package com.cakes.Service;

import com.cakes.DTO.SaveurDto;
import com.cakes.Model.Saveur;

import java.util.List;
import java.util.Optional;

public interface ISaveurService {

    SaveurDto saveSaveur(SaveurDto saveurDto) ;
    Optional<SaveurDto> getSaveurById(Long id);
    List<SaveurDto> getAllSaveurs();
    SaveurDto updateSaveur(Long id, SaveurDto saveurDto);
    void deleteSaveur(Long id);
}
