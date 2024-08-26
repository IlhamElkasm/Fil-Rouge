package com.cakes.Controller;

import com.cakes.Model.Couleur;
import com.cakes.Service.CouleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/couleur")
public class CouleurController {

    @Autowired
    private CouleurService couleurService;

    @PostMapping
    public Couleur createCouleur(@RequestBody Couleur couleur) {
        return couleurService.saveCouleur(couleur);
    }

    @PutMapping("/{id}")
    public Couleur updateCouleur(@PathVariable Long id, @RequestBody Couleur updatedCouleur) {
        Couleur existingCouleur = couleurService.getCouleurById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found"));

        existingCouleur.setName(updatedCouleur.getName());
        existingCouleur.setHexCode(existingCouleur.getHexCode());
        existingCouleur.setPrice(existingCouleur.getPrice());

        return couleurService.saveCouleur(existingCouleur);
    }

    @GetMapping
    public List<Couleur> getAllCouleurs() {
        return couleurService.getAllCouleurs();
    }

    @DeleteMapping("/{id}")
    public void deleteCouleur(@PathVariable Long id) {
        couleurService.deleteCouleur(id);
    }

}
