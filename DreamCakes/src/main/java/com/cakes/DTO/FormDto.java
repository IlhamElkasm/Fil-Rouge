package com.cakes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {

    private Long idShape;
    private String image;
    private String name;
    private String dimensions;
    private double price;
}
