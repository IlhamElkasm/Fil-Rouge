package com.cakes.Repository;

import com.cakes.Model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrateur, Long> {
}
