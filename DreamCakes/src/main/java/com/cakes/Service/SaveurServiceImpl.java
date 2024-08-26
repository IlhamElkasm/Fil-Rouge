package com.cakes.Service;

import com.cakes.Model.Saveur;
import com.cakes.Repository.SaveurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaveurServiceImpl implements SaveurService {

    @Autowired
    private SaveurRepository saveurRepository;

    @Override
    public Saveur saveSaveur(Saveur saveur) {
        return saveurRepository.save(saveur);
    }

    @Override
    public Optional<Saveur> getSaveurById(Long id) {
        return saveurRepository.findById(id);
    }

    @Override
    public List<Saveur> getAllSaveurs() {
        return saveurRepository.findAll();
    }

    @Override
    public void deleteSaveur(Long id) {
        saveurRepository.deleteById(id);
    }
}
