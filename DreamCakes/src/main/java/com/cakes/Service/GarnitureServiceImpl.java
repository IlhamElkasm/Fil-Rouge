package com.cakes.Service;

import com.cakes.Model.Garniture;
import com.cakes.Repository.GarnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarnitureServiceImpl implements GarnitureService{

    @Autowired
    private GarnitureRepository garnitureRepository;

    @Override
    public Garniture saveGarniture(Garniture garniture) {
        return garnitureRepository.save(garniture);
    }

    @Override
    public Optional<Garniture> getGarnitureById(Long id) {
        return garnitureRepository.findById(id);
    }

    @Override
    public List<Garniture> getAllGarnitures() {
        return garnitureRepository.findAll();
    }

    @Override
    public void deleteGarniture(Long id) {
        garnitureRepository.deleteById(id);
    }
}
