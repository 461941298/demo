package com.yjh.study.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.yjh.study")
public class MyConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        return new LocalContainerEntityManagerFactoryBean();
    }


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.190:3306/test");
        dataSource.setUsername("yjh");
        dataSource.setPassword("651028");
        return dataSource;
    }

    @Bean
    public EntityManager entityManager() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("spring-JPA");
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.yjh.study.entity");
        return localContainerEntityManagerFactoryBean.getObject().createEntityManager();
    }


}
