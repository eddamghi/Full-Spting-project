package eddamghi.inventory_service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("eddamghi.inventory_service.domain")
@EnableJpaRepositories("eddamghi.inventory_service.repos")
@EnableTransactionManagement
public class DomainConfig {
}
