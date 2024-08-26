package com.cakes.Service;

import com.cakes.Model.Gateau;
import com.cakes.Repository.GateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateauServiceImpl {

    @Autowired
    private GateauRepository gateauRepository;

    // Save a new Gateau
    public Gateau saveGateau(Gateau gateau) {
        return gateauRepository.save(gateau);
    }

    // Get all Gateaux
    public List<Gateau> getAllGateaux() {
        return gateauRepository.findAll();
    }

    // Get a Gateau by ID
    public Gateau getGateauById(Long id) {
        return gateauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gateau not found"));
    }

    // Delete a Gateau by ID
    public void deleteGateauById(Long id) {
        gateauRepository.deleteById(id);
    }
}
