package com.cakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouleurDto {

    private Long idColor;
    private String image;
    private String name;
    private String hexCode;
    private double price;
}
