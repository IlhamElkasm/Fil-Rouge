package com.cakes.Controller;

import com.cakes.DTO.SaveurDto;
import com.cakes.Model.Saveur;
import com.cakes.Service.ISaveurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Saveur")
@CrossOrigin(origins = "http://localhost:4200/")
public class SaveurController {

    @Autowired
    private ISaveurService saveurService;

    // Create a new Saveur
    @PostMapping("/Admin/addS")
    public ResponseEntity<SaveurDto> createSaveur(@RequestBody SaveurDto saveurDto) {
        SaveurDto savedSaveur = saveurService.saveSaveur(saveurDto);
        return new ResponseEntity<>(savedSaveur, HttpStatus.CREATED);
    }

    // Get a Saveur by ID
    @GetMapping("/getS/{id}")
    public ResponseEntity<SaveurDto> getSaveurById(@PathVariable("id") Long id) {
        Optional<SaveurDto> saveurDto = saveurService.getSaveurById(id);
        return saveurDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Saveurs
    @GetMapping("/all")
    public ResponseEntity<List<SaveurDto>> getAllSaveurs() {
        List<SaveurDto> saveurDtos = saveurService.getAllSaveurs();
        return ResponseEntity.ok(saveurDtos);
    }

    // Update a Saveur
    @PutMapping("/edit/{id}")
    public ResponseEntity<SaveurDto> updateSaveur(@PathVariable("id") Long id, @RequestBody SaveurDto saveurDto) {
        SaveurDto updatedSaveur = saveurService.updateSaveur(id, saveurDto);
        if (updatedSaveur != null) {
            return ResponseEntity.ok(updatedSaveur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Saveur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSaveur(@PathVariable("id") Long id) {
        saveurService.deleteSaveur(id);
        return ResponseEntity.noContent().build();
    }
}