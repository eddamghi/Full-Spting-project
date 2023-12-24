package eddamghi.order_service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("eddamghi.order_service.domain")
@EnableJpaRepositories("eddamghi.order_service.repos")
@EnableTransactionManagement
public class DomainConfig {
}
