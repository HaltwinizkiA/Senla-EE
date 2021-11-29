package com.senla.haltvinizki.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@WebAppConfiguration
@EnableWebMvc
@ComponentScan("com.senla.haltvinizki")
public class WebConfiguration {
}
