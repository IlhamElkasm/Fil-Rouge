package com.cakes.Controller;

import com.cakes.DTO.GateauDto;
import com.cakes.Model.Gateau;
import com.cakes.Service.GateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/User/gateau")
public class GateauController {

    @Autowired
    private GateauService gateauService;

    // Create a new cake (Gateau) using shapeId, flavorId, and toppingId
    @PostMapping
    public GateauDto createGateau(@RequestBody GateauDto gateauDto) {
        return gateauService.createGateau(gateauDto);
    }

    @GetMapping("/{id}")
    public Optional<Gateau> getGateauById(@PathVariable Long id) {
        return gateauService.getGateauById(id);
    }

}
