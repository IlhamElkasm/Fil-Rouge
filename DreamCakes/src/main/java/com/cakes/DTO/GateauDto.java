package com.cakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GateauDto {
    private String nom;
    private String message;
    private Long shapeId;
    private Long flavorId;
    private Long colorId;
    private List<Long> toppingIds;

    // Getters and Setters
}
