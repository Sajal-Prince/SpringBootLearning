package com.example.start1.DTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {
    @NotNull(message = "Name cannot be null")
    private String name;
    @Min(value = 0,message = "Value cannot be Negative")
    private int quantity;
}
