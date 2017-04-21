//package com.joseph.configuration;
//
//import org.hibernate.dialect.MySQL5Dialect;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.util.Properties;
//
///**
// * Created by joseph on 4/8/17.
// * Email: developergitch@outlook.com
// *
// */
//
///**
// * This class act as the base configuration class for both service beans and any other dao beans
// */
//@ComponentScan(basePackages = {"com.joseph.services"})
//@Configuration
//@EnableTransactionManagement()
//public class RootConfig {
//    //transaction manager
//    @Bean
//    public HibernateTransactionManager transactionManager(){
//        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
//        transactionManager.setDataSource(dataSource());
//
//        return transactionManager;
//    }
//
//    //Data source definirions
//    @Bean
//    public DriverManagerDataSource dataSource(){
//        DriverManagerDataSource dataSource=new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/SpareUI");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setPassword("13097");
//        dataSource.setUsername("joseph");
//        return dataSource;
//    }
//    //session factory
//    @Bean
//    public LocalSessionFactoryBean sessionFactoryBean(){
//        LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
//        sessionFactoryBean.setAnnotatedPackages("com.joseph.models");
//        sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate-conf.xml"));
//        Properties properties=new Properties();
//        properties.put("show_sql",true);
//        properties.put("hibernate.dialect", MySQL5Dialect.class);
//        properties.put("hbm2ddl.auto","create-drop");
//        sessionFactoryBean.setHibernateProperties(properties);
//        sessionFactoryBean.setDataSource(dataSource());
//        return sessionFactoryBean;
//    }
//
//
//}
