package eddamghi.order_service.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderItemDTO {

    private Long id;

    @NotNull
    private Long quantity;

    @NotNull
    private Double unitPrice;

    private Double discount;

    @NotNull
    private Long productId;

    @NotNull
    private Long order;

}
