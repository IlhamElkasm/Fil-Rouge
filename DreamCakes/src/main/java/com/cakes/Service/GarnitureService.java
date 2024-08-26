package com.cakes.Service;

import com.cakes.Model.Garniture;

import java.util.List;
import java.util.Optional;

public interface GarnitureService {

    Garniture saveGarniture(Garniture garniture);
    Optional<Garniture> getGarnitureById(Long id);
    List<Garniture> getAllGarnitures();
    void deleteGarniture(Long id);
}
