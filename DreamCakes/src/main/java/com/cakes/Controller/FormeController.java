package com.cakes.Controller;

import com.cakes.Model.Forme;
import com.cakes.Service.FormeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/shapes")
public class FormeController {

    @Autowired
    private FormeService formService;

    @PostMapping
    public Forme createForme(@RequestBody Forme shape) {
        return formService.saveForme(shape);
    }

    @PutMapping("/{id}")
    public Forme updateForme(@PathVariable Long id, @RequestBody Forme updatedForme) {
        Forme existingForme = formService.getFormeById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found"));

        existingForme.setName(updatedForme.getName());
        existingForme.setDimensions(updatedForme.getDimensions());
        existingForme.setPrice(updatedForme.getPrice());

        return formService.saveForme(existingForme);
    }

    @GetMapping
    public List<Forme> getAllFormes() {
        return formService.getAllFormes();
    }

    @DeleteMapping("/{id}")
    public void deleteForme(@PathVariable Long id) {
        formService.deleteForme(id);
    }
}
