package com.cakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommendeDto {

    private Long idCommende;
    private LocalDate dateCommende;
    private Long gateauId; // Reference to Gateau
//    private Long livraisonId; // Reference to Livraison

}
