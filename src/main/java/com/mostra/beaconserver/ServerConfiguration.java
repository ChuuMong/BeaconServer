package com.mostra.beaconserver;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by yoontaesup on 2015. 2. 25..
 */
@Configuration
@EnableWebMvc
@ComponentScan
@EnableAsync
public class ServerConfiguration extends WebMvcAutoConfiguration {

}
