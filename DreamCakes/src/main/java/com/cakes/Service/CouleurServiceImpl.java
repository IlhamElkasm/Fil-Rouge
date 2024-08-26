package com.cakes.Service;

import com.cakes.Model.Couleur;
import com.cakes.Repository.CouleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouleurServiceImpl implements CouleurService{

    @Autowired
    private CouleurRepository couleurRepository;

    @Override
    public Couleur saveCouleur(Couleur couleur) {
        return couleurRepository.save(couleur);
    }

    @Override
    public Optional<Couleur> getCouleurById(Long id) {
        return couleurRepository.findById(id);
    }

    @Override
    public List<Couleur> getAllCouleurs() {
        return couleurRepository.findAll();
    }

    @Override
    public void deleteCouleur(Long id) {
        couleurRepository.deleteById(id);
    }
}
