package com.cakes.Service;

import com.cakes.DTO.CouleurDto;
import com.cakes.Model.Couleur;
import com.cakes.Repository.CouleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouleurService implements ICouleurService {

    @Autowired
    private CouleurRepository couleurRepository;


    @Override
    public CouleurDto saveCouleur(CouleurDto couleurDto) {
        Couleur couleur = new Couleur();
        couleur.setName(couleurDto.getName());
        couleur.setImage(couleurDto.getImage());
        couleur.setHexCode(couleurDto.getHexCode());
        couleur.setPrice(couleurDto.getPrice());
        couleurRepository.save(couleur);

        CouleurDto savecouleurDto = new CouleurDto();
        savecouleurDto.setName(couleur.getName());
        savecouleurDto.setImage(couleur.getImage());
        savecouleurDto.setHexCode(couleur.getHexCode());
        savecouleurDto.setPrice(couleur.getPrice());
        return savecouleurDto;
    }

    @Override
    public CouleurDto updateCouleur(CouleurDto couleurDto, Long id) {

        Optional<Couleur> couleur = couleurRepository.findById(id);
        if (couleur.isPresent()) {
            couleur.get().setName(couleurDto.getName());
            couleur.get().setImage(couleurDto.getImage());
            couleur.get().setHexCode(couleurDto.getHexCode());
            couleur.get().setPrice(couleurDto.getPrice());
            couleurRepository.save(couleur.get());

            CouleurDto savecouleurDto = new CouleurDto();
            savecouleurDto.setName(couleurDto.getName());
            savecouleurDto.setImage(couleurDto.getImage());
            savecouleurDto.setHexCode(couleurDto.getHexCode());
            savecouleurDto.setPrice(couleurDto.getPrice());
            return savecouleurDto;
        }
        return null;
    }

    @Override
    public Optional<CouleurDto> getCouleurById(Long id) {

        Couleur couleur = couleurRepository.findById(id).orElse(null);
        if (couleur != null) {
            CouleurDto couleurDto = new CouleurDto();
            couleurDto.setName(couleur.getName());
            couleurDto.setImage(couleur.getImage());
            couleurDto.setHexCode(couleur.getHexCode());
            couleurDto.setPrice(couleur.getPrice());
            return Optional.of(couleurDto);
        }
        return Optional.empty();
    }

    @Override
    public List<CouleurDto> getAllCouleurs() {
        List<Couleur> couleurs = couleurRepository.findAll();
        return couleurs.stream().map(couleur -> {
            CouleurDto couleurDto = new CouleurDto();
            couleurDto.setName(couleur.getName());
            couleurDto.setImage(couleur.getImage());
            couleurDto.setHexCode(couleur.getHexCode());
            couleurDto.setPrice(couleur.getPrice());
            return couleurDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteCouleur(Long id) {
        couleurRepository.deleteById(id);
    }
}
