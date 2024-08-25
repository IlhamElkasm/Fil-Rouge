package com.cakes.Controller;

import com.cakes.Model.Forme;
import com.cakes.Service.FormeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shapes")
public class FormeController {
    @Autowired
    private FormeService formService;

    @PostMapping
    public Forme createShape(@RequestBody Forme shape) {
        return formService.saveShape(shape);
    }

    @GetMapping("/{id}")
    public Forme getShapeById(@PathVariable Long id) {
        return formService.getShapeById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found"));
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
