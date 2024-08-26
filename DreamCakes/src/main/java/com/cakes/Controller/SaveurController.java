package com.cakes.Controller;

import com.cakes.Model.Saveur;
import com.cakes.Service.SaveurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/saveur")
public class SaveurController {

    @Autowired
    private SaveurService saveurService;

    @PostMapping
    public Saveur createSaveur(@RequestBody Saveur saveur) {
        return saveurService.saveSaveur(saveur);
    }

    @PutMapping("/{id}")
    public Saveur updateSaveur(@PathVariable Long id, @RequestBody Saveur updatedForme) {
        Saveur existingSaveur = saveurService.getSaveurById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found"));

        existingSaveur.setName(updatedForme.getName());
        existingSaveur.setPrice(updatedForme.getPrice());

        return saveurService.saveSaveur(existingSaveur);
    }

    @GetMapping
    public List<Saveur> getAllSaveurs() {
        return saveurService.getAllSaveurs();
    }

    @DeleteMapping("/{id}")
    public void deleteSaveur(@PathVariable Long id) {
        saveurService.deleteSaveur(id);
    }
}
