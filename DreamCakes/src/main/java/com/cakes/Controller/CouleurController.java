package com.cakes.Controller;

import com.cakes.DTO.CouleurDto;
import com.cakes.DTO.GarnitureDto;
import com.cakes.Model.Couleur;
import com.cakes.Service.ICouleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/couleur")
public class CouleurController {

    @Autowired
    private ICouleurService couleurService;

    @PostMapping
    public CouleurDto createCouleur(@RequestBody CouleurDto couleurDto) {
        return couleurService.saveCouleur(couleurDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouleurDto> updateCouleur(@PathVariable Long id, @RequestBody CouleurDto updatedCouleur) {
        CouleurDto updatedcouleur = couleurService.updateCouleur(updatedCouleur, id);
        if (updatedcouleur != null) {
            return ResponseEntity.ok(updatedcouleur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouleurDto> getCouleuById(@PathVariable("id") Long id) {
        Optional<CouleurDto> couleuDto = couleurService.getCouleurById(id);
        return couleuDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CouleurDto> getAllCouleurs() {

        return couleurService.getAllCouleurs();
    }

    @DeleteMapping("/{id}")
    public void deleteCouleur(@PathVariable Long id) {
        couleurService.deleteCouleur(id);
    }

}
