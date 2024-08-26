package com.cakes.Controller;

import com.cakes.Model.Forme;
import com.cakes.Model.Garniture;
import com.cakes.Service.GarnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/garniture")
public class GarnitureController {

    @Autowired
    private GarnitureService garnitureService;

    @PostMapping
    public Garniture createGarniture(@RequestBody Garniture garniture) {
        return garnitureService.saveGarniture(garniture);
    }

    @PutMapping("/{id}")
    public Garniture updateForme(@PathVariable Long id, @RequestBody Garniture updatedGarniture) {
        Garniture existingGarniture = garnitureService.getGarnitureById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found"));

        existingGarniture.setName(updatedGarniture.getName());
        existingGarniture.setPrice(updatedGarniture.getPrice());

        return garnitureService.saveGarniture(existingGarniture);
    }

    @GetMapping
    public List<Garniture> getAllFormes() {
        return garnitureService.getAllGarnitures();
    }

    @DeleteMapping("/{id}")
    public void deleteForme(@PathVariable Long id) {
        garnitureService.deleteGarniture(id);
    }
}
