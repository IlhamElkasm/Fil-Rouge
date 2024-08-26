package com.cakes.Service;

import com.cakes.Model.Couleur;
import com.cakes.Model.Saveur;

import java.util.List;
import java.util.Optional;

public interface SaveurService {

    Saveur saveSaveur(Saveur saveur);
    Optional<Saveur> getSaveurById(Long id);
    List<Saveur> getAllSaveurs();
    void deleteSaveur(Long id);
}
