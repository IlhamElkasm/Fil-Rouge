package com.cakes.Service;

import com.cakes.Model.Forme;

import java.util.List;
import java.util.Optional;

public interface FormeService {
    Forme saveForme(Forme shape);
    Optional<Forme> getFormeById(Long id);
    List<Forme> getAllFormes();
    void deleteForme(Long id);
}
