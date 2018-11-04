package com.yangrui.bo;

import java.util.Properties;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableTransactionManagement
@ComponentScan(value="com.yangrui.bo",excludeFilters= {
		@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
})
@MapperScan({"com.yangrui.bo.dao"})
public class RootConfig {

	@Bean
	public DataSource dataSource() throws Exception {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("134167");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=utf-8");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setMaxPoolSize(3);
		dataSource.setMinPoolSize(1);
		dataSource.setCheckoutTimeout(1000);
		dataSource.setAutoCommitOnClose(false);
		return dataSource;
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		Properties properties=new Properties();
		properties.setProperty("useGeneratedKeys", "true");
		properties.setProperty("useColumnLabel", "true");
		properties.setProperty("mapUnderscoreToCamelCase", "true");
		sqlSessionFactoryBean.setConfigurationProperties(properties);
		
		return sqlSessionFactoryBean;
	}
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
		DataSourceTransactionManager transactionManager=new DataSourceTransactionManager(dataSource());
		return transactionManager;
	}
}