package com.cakes.Controller;

import com.cakes.DTO.GarnitureDto;
import com.cakes.DTO.SaveurDto;
import com.cakes.Model.Garniture;
import com.cakes.Service.IGarnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/garniture")
@CrossOrigin(origins = "http://localhost:4200/")
public class GarnitureController {

    @Autowired
    private IGarnitureService garnitureService;

    @PostMapping
    public GarnitureDto createGarniture(@RequestBody GarnitureDto garnitureDto) {
        return garnitureService.saveGarniture(garnitureDto);
    }

    // Update a Saveur
    @PutMapping("/{id}")
    public ResponseEntity<GarnitureDto> updateSaveur(@PathVariable("id") Long id, @RequestBody GarnitureDto garnitureDto) {
        GarnitureDto updatedgarniture = garnitureService.updateGarniture(garnitureDto, id);
        if (updatedgarniture != null) {
            return ResponseEntity.ok(updatedgarniture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get a Saveur by ID
    @GetMapping("/{id}")
    public ResponseEntity<GarnitureDto> getGarnitureById(@PathVariable("id") Long id) {
        Optional<GarnitureDto> garnitureDto = garnitureService.getGarnitureById(id);
        return garnitureDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<GarnitureDto> getAllFormes() {
        return garnitureService.getAllGarnitures();
    }

    @DeleteMapping("/{id}")
    public void deleteForme(@PathVariable Long id) {
        garnitureService.deleteGarniture(id);
    }
}
