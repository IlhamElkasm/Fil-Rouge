package com.cakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarnitureDto {

    private Long idTopping;
    private String image;
    private String name;
    private double price;
}
