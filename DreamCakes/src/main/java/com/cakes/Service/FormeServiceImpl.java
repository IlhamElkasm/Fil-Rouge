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

    public Forme saveForme(Forme shape) {
        return formeRepository.save(shape);
    }

    public Optional<Forme> getFormeById(Long id) {
        return formeRepository.findById(id);
    }

    public List<Forme> getAllFormes() {
        return formeRepository.findAll();
    }

    public void deleteForme(Long id) {
        formeRepository.deleteById(id);
    }
}