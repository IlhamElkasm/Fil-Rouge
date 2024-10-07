package com.cakes.Repository;

import com.cakes.Model.Garniture;
import com.cakes.Model.Gateau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface GarnitureRepository extends JpaRepository<Garniture, Long> {

}
