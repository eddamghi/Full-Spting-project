package eddamghi.inventory_service.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    @NotNull
    private State state;

    @NotNull
    private Long category;

}
