package com.cakes.Controller;

import com.cakes.DTO.GateauDto;
import com.cakes.Model.*;
import com.cakes.Repository.*;
import com.cakes.Service.GateauServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/User/gateau")
public class GateauController {

    @Autowired
    private GateauServiceImpl gateauService;

    @Autowired
    private FormeRepository shapeRepository;

    @Autowired
    private SaveurRepository flavorRepository;


    @Autowired
    private GarnitureRepository toppingRepository;

    @PostMapping
    public Gateau createGateau(@RequestBody GateauDto gateauDto) {
        Gateau gateau = new Gateau();

        gateau.setNom(gateauDto.getNom());
        gateau.setMessage(gateauDto.getMessage());

        // Fetch and set Shape
        Forme shape = shapeRepository.findById(gateauDto.getShapeId())
                .orElseThrow(() -> new RuntimeException("Shape not found"));
        gateau.setForme(shape);

        // Fetch and set Flavor
        Saveur flavor = flavorRepository.findById(gateauDto.getFlavorId())
                .orElseThrow(() -> new RuntimeException("Flavor not found"));
        gateau.setSaveur(flavor);

        // Fetch and set Toppings
        Garniture toppings = (Garniture) toppingRepository.findAllById(gateauDto.getToppingIds());
        gateau.setGarnitures(toppings);

        // Save the Gateau
        return gateauService.saveGateau(gateau);
    }
}

