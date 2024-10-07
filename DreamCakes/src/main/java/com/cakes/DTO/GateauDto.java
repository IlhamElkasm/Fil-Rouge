package com.cakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GateauDto {
    private  Long idGateau;
    private String message;
    private Double prixtotal;
    private Long idShape;
    private Long idFlavor;
    private Long idTopping;

    // Getters and Setters
}
