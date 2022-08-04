package com.br.rocha.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.br.rocha.repository.loja.recife.RepositoryLojaRecife;

@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryLojaRecife.class, entityManagerFactoryRef = "recifeEntityManager")
public class LojaRecifeDbConfig {

	@Bean
	@ConfigurationProperties("recife.datasource")
	DataSource lojaRecifeDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	LocalContainerEntityManagerFactoryBean recifeEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("lojaRecifeDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.br.rocha.entity.loja.recife").build();

	}

}
