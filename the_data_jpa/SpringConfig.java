package com.oukele.the_data_jpa;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration//声明当前配置类
@ComponentScan(basePackages = "com.oukele.the_data_jpa")// 扫描当前包 使用 spring 注解
@PropertySource("classpath:jdbc.properties")//加载 资源文件
@EnableJpaRepositories(basePackages = "com.oukele.the_data_jpa.dao")//扫描 使用 jpa 注解的接口
public class SpringConfig {

    //配置数据源
    @Bean
    DataSource dataSource(Environment env) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return  dataSource;
    }

    //SqlSessionFactory
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){

        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("com.oukele.the_data_jpa.entity");//扫描实体类
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");//加载hibernate自动更新数据库结构
        //格式化输出语法
        properties.setProperty("hibernate.format_sql","true")
        //显示格式化的语法
        properties.setProperty("hibernate.format_sql","true")
        //数据库设置哪一种数据库
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        bean.setJpaProperties(properties);

        return bean;
    }



}
