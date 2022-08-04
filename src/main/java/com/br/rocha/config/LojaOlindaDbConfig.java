package com.br.rocha.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.br.rocha.repository.loja.olinda.RepositoryLojaOlinda;

@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryLojaOlinda.class, entityManagerFactoryRef = "olindaEntityManager")
public class LojaOlindaDbConfig {

	@Bean
	@Primary
	@ConfigurationProperties("olinda.datasource")
	DataSource lojaOlindaDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	LocalContainerEntityManagerFactoryBean olindaEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("lojaOlindaDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.br.rocha.entity.loja.olinda").build();

	}

}
