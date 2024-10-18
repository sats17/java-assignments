package com.github.sats17.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@EnableConfigurationProperties
@Configuration
@EnableJpaRepositories(
        basePackages = "com.github.sats17.repository.h2",
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager"
)
public class LocalH2Config {

    @Bean(name = "h2DataSource")
    @ConfigurationProperties("spring.datasource.h2")
    @Primary
    public DataSource h2DataSource() {

        return DataSourceBuilder.create()
//                                .url("jdbc:h2:mem:localh2DataSourcetestdb")
//                                .driverClassName("org.h2.Driver")
//                .username("admin").password("admin")
                                .build();
//        try {
//            System.out.println("DataSource URL: " + dataSource.getConnection().getMetaData().getURL());
//        } catch (SQLException e) {
//            System.out.println("Exce[tpoasfasfasfas");
//        }
//        return dataSource;
    }

    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(h2DataSource())
                .packages("com.github.sats17.models.h2") // Entities for MySQL
                .persistenceUnit("h2")
                .build();
    }

    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager databaseATransactionManager(
            @Qualifier("h2EntityManagerFactory") EntityManagerFactory h2EntityManagerFactory) {
        return new JpaTransactionManager(h2EntityManagerFactory);
    }

}
