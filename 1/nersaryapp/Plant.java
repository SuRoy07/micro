package com.plantnursery.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant {

    @NotEmpty(message = "Provide value for Plant Id")
    private String plantId;

    @NotEmpty(message = "Provide value for Plant name")
    private String plantName;

    @Min(value = 1, message = "Provide value greater than zero")
    private int quantity;

    @NotEmpty(message = "Provide value for Plant type")
    private String plantType;

    private double price;

}
