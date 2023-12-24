package eddamghi.order_service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderAnalyticEvent {
    private Long ordersCount;
    private Double totalAmount;
}
