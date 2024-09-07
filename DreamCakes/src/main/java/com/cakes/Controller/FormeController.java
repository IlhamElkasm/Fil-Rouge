package com.cakes.Controller;

import com.cakes.DTO.FormDto;
import com.cakes.Model.Forme;
import com.cakes.Service.IFormeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class FormeController {

    @Autowired
    private IFormeService formeService;

    // Create Forme
    @PostMapping("/shapes")
    public ResponseEntity<FormDto> createForme(@RequestBody FormDto formDto) {
        FormDto savedForme = formeService.saveForme(formDto);
        return ResponseEntity.ok(savedForme);
    }

    // Get Forme by ID
    @GetMapping("/shapes/{id}")
    public ResponseEntity<FormDto> getFormeById(@PathVariable Long id) {
        Optional<FormDto> forme = formeService.getFormeById(id);
        return forme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Formes
    @GetMapping("/User/shapes")
    public ResponseEntity<List<FormDto>> getAllFormes() {
        List<FormDto> formes = formeService.getAllFormes();
        return ResponseEntity.ok(formes);
    }

    // Update Forme
    @PutMapping("/shapes/{id}")
    public ResponseEntity<FormDto> updateForme(@PathVariable Long id, @RequestBody FormDto formDto) {
        Optional<FormDto> updatedForme = formeService.updateForme(id, formDto);
        return updatedForme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Forme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForme(@PathVariable Long id) {
        formeService.deleteForme(id);
        return ResponseEntity.noContent().build();
    }
}
