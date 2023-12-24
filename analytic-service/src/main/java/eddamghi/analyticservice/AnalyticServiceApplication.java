package eddamghi.analyticservice;

import eddamghi.analyticservice.event.OrderAnalyticEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AnalyticServiceApplication {

        public static void main(String[] args) {
            SpringApplication.run(AnalyticServiceApplication.class, args);
        }
        @KafkaListener(topics = "orderAnalyticTopic")
        public void orderAnalyticListener(OrderAnalyticEvent event) {
            log.info("Orders : {} | Total : {}", event.getOrdersCount(), event.getTotalAmount());
        }
}
