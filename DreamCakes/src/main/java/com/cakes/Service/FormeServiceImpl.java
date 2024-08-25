package com.cakes.Service;

import com.cakes.Model.Forme;
import com.cakes.Repository.FormeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormeServiceImpl implements FormeService {

    @Autowired
    private FormeRepository formeRepository;

    public Forme saveShape(Forme shape) {
        return formeRepository.save(shape);
    }

    public Optional<Forme> getShapeById(Long id) {
        return formeRepository.findById(id);
    }

    public List<Forme> getAllShapes() {
        return formeRepository.findAll();
    }

    public void deleteShape(Long id) {
        formeRepository.deleteById(id);
    }
}