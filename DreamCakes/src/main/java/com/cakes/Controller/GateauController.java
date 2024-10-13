package com.cakes.Controller;

import com.cakes.DTO.GateauDto;
import com.cakes.Model.Gateau;
import com.cakes.Service.GateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/User")
@CrossOrigin(origins = "http://localhost:4200/")
public class GateauController {

    @Autowired
    private GateauService gateauService;

    // Create a new cake (Gateau) using shapeId, flavorId, and toppingId
//    @PostMapping
//    public GateauDto createGateau(@RequestBody GateauDto gateauDto) {
//        return gateauService.createGateau(gateauDto);
//    }

    @PostMapping("/gateau")
    public ResponseEntity<GateauDto> createGateau(@RequestBody GateauDto gateauDto) {
        GateauDto createdGateau = gateauService.createGateau(gateauDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGateau);
    }


    @GetMapping("/cake/{id}")
    public Optional<Gateau> getGateauById(@PathVariable Long id) {
        return gateauService.getGateauById(id);
    }

}
