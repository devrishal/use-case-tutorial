package com.rds.barcodegen;

import com.rds.barcodegen.domain.service.xls.generic.strategy.XlsCellValueStrategyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@EnablePluginRegistries(XlsCellValueStrategyService.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
