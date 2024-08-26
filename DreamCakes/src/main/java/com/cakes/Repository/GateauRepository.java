package com.cakes.Repository;

import com.cakes.Model.Gateau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateauRepository extends JpaRepository<Gateau, Long> {
}
