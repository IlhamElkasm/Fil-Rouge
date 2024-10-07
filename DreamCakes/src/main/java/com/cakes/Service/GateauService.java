package com.cakes.Service;

import com.cakes.DTO.GateauDto;
import com.cakes.Mapper.GateauMapper;
import com.cakes.Model.Forme;
import com.cakes.Model.Garniture;
import com.cakes.Model.Gateau;
import com.cakes.Model.Saveur;
import com.cakes.Repository.FormeRepository;
import com.cakes.Repository.GarnitureRepository;
import com.cakes.Repository.GateauRepository;
import com.cakes.Repository.SaveurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GateauService implements IGateauService {


    @Autowired
    private GateauRepository gateauRepository;

    @Autowired
    private GateauMapper gateauMapper;

    @Autowired
    private FormeRepository formeRepository;

    @Autowired
    private SaveurRepository saveurRepository;

    @Autowired
    private GarnitureRepository garnitureRepository;

    // Create method with price calculation using IDs

    public GateauDto createGateau(GateauDto gateauDto) {
        Gateau gateau = gateauMapper.toEntity(gateauDto);

        // Initialize total price
        double totalPrice = 0.0;

        // Fetch and add Forme price by ID
        if (gateauDto.getIdShape() != null) {
            Optional<Forme> forme = formeRepository.findById(gateauDto.getIdShape());
            if (forme.isPresent()) {
                totalPrice += forme.get().getPrice();
                gateau.setForme(forme.get());
            }
        }

        // Fetch and add Saveur price by ID
        if (gateauDto.getIdFlavor() != null) {
            Optional<Saveur> saveur = saveurRepository.findById(gateauDto.getIdFlavor());
            if (saveur.isPresent()) {
                totalPrice += saveur.get().getPrice();
                gateau.setSaveur(saveur.get());
            }
        }

        // Fetch and add Garniture price by ID
        if (gateauDto.getIdTopping() != null) {
            Optional<Garniture> garniture = garnitureRepository.findById(gateauDto.getIdTopping());
            if (garniture.isPresent()) {
                totalPrice += garniture.get().getPrice();
                gateau.setGarnitures(garniture.get());
            }
        }

        // Set the total calculated price
        gateau.setPrixtotal(totalPrice);

        // Save the Gateau and return the DTO
        Gateau savedGateau = gateauRepository.save(gateau);
        return gateauMapper.toDTO(savedGateau);
    }

    public Optional<Gateau> getGateauById(Long id) {
        return gateauRepository.findById(id);
    }
}
