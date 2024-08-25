package com.cakes.Repository;

import com.cakes.Model.Forme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.Normalizer;

public interface FormeRepository extends JpaRepository<Forme, Long> {
}
