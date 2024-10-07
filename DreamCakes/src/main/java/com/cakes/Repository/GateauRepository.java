package com.cakes.Repository;

import com.cakes.Model.Gateau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GateauRepository extends JpaRepository<Gateau, Long> {

    Optional<Gateau> findById(Long id);
}
