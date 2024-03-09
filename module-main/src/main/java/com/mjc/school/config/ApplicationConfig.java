package com.mjc.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "com.mjc.school")
public class ApplicationConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/MukhaDB");
        dataSource.setUsername("Muka");
        dataSource.setPassword("310857");
        return dataSource;
    }
    @Bean("entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {

        return Persistence.createEntityManagerFactory("KarimNews");
    }
}
