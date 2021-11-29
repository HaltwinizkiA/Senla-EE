package com.senla.haltvinizki.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.senla.haltvinizki")
@WebAppConfiguration
public class WebConfiguration {
}
