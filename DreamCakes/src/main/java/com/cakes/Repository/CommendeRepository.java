package com.cakes.Repository;

import com.cakes.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommendeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findByUserId(Long userId);

}
