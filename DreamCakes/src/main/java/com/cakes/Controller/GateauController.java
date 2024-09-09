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

        // N7eddu smya w message
        gateau.setNom(gateauDto.getNom());
        gateau.setMessage(gateauDto.getMessage());

        // N9elbu forme b ID dialha
        Forme shape = shapeRepository.findById(gateauDto.getShapeId())
                .orElseThrow(() -> new RuntimeException("Forme makaynash"));
        gateau.setForme(shape);

        // N9elbu saveur b ID dialha
        Saveur flavor = flavorRepository.findById(gateauDto.getFlavorId())
                .orElseThrow(() -> new RuntimeException("Saveur makaynash"));
        gateau.setSaveur(flavor);

        // N9elbu garniture b ID dialha (had l'ID wahd)
        Garniture topping = toppingRepository.findById(gateauDto.getToppingId())
                .orElseThrow(() -> new RuntimeException("Garniture makaynash"));
        gateau.setGarnitures(topping); // L'ID ghadi ykoun wahd

        // Nsavgu gateau
        return gateauService.saveGateau(gateau);
    }
}
