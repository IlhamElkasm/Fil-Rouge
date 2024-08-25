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
    public Forme createShape(@RequestBody Forme shape) {
        return formService.saveShape(shape);
    }

    @PutMapping("/{id}")
    public Forme updateShape(@PathVariable Long id, @RequestBody Forme updatedForme) {
        Forme existingForme = formService.getShapeById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found"));

        existingForme.setName(updatedForme.getName());
        existingForme.setDimensions(updatedForme.getDimensions());
        existingForme.setPrice(updatedForme.getPrice());

        return formService.saveShape(existingForme);
    }

    @GetMapping
    public List<Forme> getAllShapes() {
        return formService.getAllShapes();
    }

    @DeleteMapping("/{id}")
    public void deleteShape(@PathVariable Long id) {
        formService.deleteShape(id);
    }
}
