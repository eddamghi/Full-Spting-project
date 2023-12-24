package eddamghi.order_service.service;


import eddamghi.order_service.event.OrderAnalyticEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
@RequiredArgsConstructor
public class AnalyticService {
    private final KafkaTemplate<String, OrderAnalyticEvent> kafkaTemplate;
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @Bean
    public void analytics() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                var orders = orderService.findAll();
                var orderItems = orderItemService.findAll();
                var ordersCount = orders.size();
                var ordersTotal = orders.stream().mapToDouble(order ->
                        orderItems.stream().filter(orderItem ->
                                        orderItem.getOrder().equals(order.getId()))
                                .mapToDouble(orderItem -> orderItem.getQuantity() * orderItem.getUnitPrice())
                                .sum()
                ).sum();
                kafkaTemplate.send("orderAnalyticTopic", new OrderAnalyticEvent((long) ordersCount, ordersTotal));
            }
        }, 0, 5000);

    }
}
