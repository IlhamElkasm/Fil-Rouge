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
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class FormeController {

    @Autowired
    private IFormeService formeService;

    // Create Forme
    @PostMapping("/Admin/shapes")
    public ResponseEntity<FormDto> createForme(@RequestBody FormDto formDto) {
        FormDto savedForme = formeService.saveForme(formDto);
        return ResponseEntity.ok(savedForme);
    }

    // Get all Formes
    @GetMapping("/show")
    public ResponseEntity<List<FormDto>> getAllFormes() {
        List<FormDto> formes = formeService.getAllFormes();
        return ResponseEntity.ok(formes);
    }

    // Get Forme by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<FormDto> getFormeById(@PathVariable Long id) {
        Optional<FormDto> forme = formeService.getFormeById(id);
        return forme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Update Forme
    @PutMapping("/update/{id}")
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
