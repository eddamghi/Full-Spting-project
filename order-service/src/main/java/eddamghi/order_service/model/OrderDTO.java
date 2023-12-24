package eddamghi.order_service.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderDTO {

    private Long id;

    @NotNull
    private LocalDateTime orderDate;

    @NotNull
    private LocalDateTime deliveryDate;

    @NotNull
    @Size(max = 255)
    private String deliveryAddress;

    @NotNull
    private OrderStatus status;

    @NotNull
    private Long customerId;

}
