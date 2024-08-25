package com.cakes.Service;

import com.cakes.Model.Forme;

import java.util.List;
import java.util.Optional;

public interface FormeService {
    Forme saveShape(Forme shape);
    Optional<Forme> getShapeById(Long id);
    List<Forme> getAllShapes();
    void deleteShape(Long id);
}
