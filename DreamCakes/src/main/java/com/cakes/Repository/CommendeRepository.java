package com.cakes.Repository;

import com.cakes.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommendeRepository extends JpaRepository<Commande, Long> {
}
