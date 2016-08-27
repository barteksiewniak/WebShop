package com.webshop.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * <h1>Hibernate Config Class</h1>
 * Class responsible for all Hibernate configuration. Full Java configuration in the replacement of older XML.
 *
 * @author Bartosz Siewniak
 * @version 1.0
 * @since 2016-07-08
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.webshop.configuration"})
@PropertySource(value = {"classpath:application.properties", "classpath:database.properties"})
public class HibernateConfiguration
{
    @Autowired
    private Environment environment;


    /**
     * FactoryBean that creates a JPA EntityManagerFactory according to JPA's standard container bootstrap contract.
     * This is the most powerful way to set up a shared JPA EntityManagerFactory in a Spring application context.
     *
     * @return LocalContainerEntityManagerFactoryBean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("com.webshop.model");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());

        return entityManagerFactoryBean;
    }

    /**
     * A factory for connections to the physical data source that this DataSource object represents.
     * An alternative to the DriverManager facility, a DataSource object is the preferred means of getting a connection.
     * An object that implements the DataSource interface will typically be registered with a naming service based on
     * the JavaTM Naming and Directory (JNDI) API.
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    /**
     * The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded
     * from a stream. Each key and its corresponding value in the property list is a string.
     *
     * @return Properties
     */
    private Properties hibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    /**
     * This is the central interface in Spring's transaction infrastructure. Applications can use this directly, but it
     * is not primarily meant as API: Typically, applications will work with either TransactionTemplate or declarative
     * transaction demarcation through AOP.
     *
     * @param entityManagerFactory Interface used to interact with the entity manager factory for the persistence unit.
     * @return PlatformTransactionManager
     */
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    /**
     * Bean post-processor that automatically applies persistence exception translation to any bean marked with
     * Spring's @Repository annotation, adding a corresponding PersistenceExceptionTranslationAdvisor to the exposed
     * proxy (either an existing AOP proxy or a newly generated proxy that implements all of the target's interfaces).
     *
     * @return PersistenceExceptionTranslationPostProcessor
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
    {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}

