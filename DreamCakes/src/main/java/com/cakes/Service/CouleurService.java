package com.cakes.Service;

import com.cakes.Model.Couleur;
import com.cakes.Model.Forme;

import java.util.List;
import java.util.Optional;

public interface CouleurService {
    Couleur saveCouleur(Couleur couleur);
    Optional<Couleur> getCouleurById(Long id);
    List<Couleur> getAllCouleurs();
    void deleteCouleur(Long id);
}
