package com.cakes.Service;

import com.cakes.DTO.CouleurDto;
import com.cakes.Model.Couleur;

import java.util.List;
import java.util.Optional;

public interface ICouleurService {

    CouleurDto saveCouleur(CouleurDto couleurDto);
    CouleurDto updateCouleur(CouleurDto couleurDto, Long id);
    Optional<CouleurDto> getCouleurById(Long id);
    List<CouleurDto> getAllCouleurs();
    void deleteCouleur(Long id);
}
