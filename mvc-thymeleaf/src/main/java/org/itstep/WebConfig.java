/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itstep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ViewResolverRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 *
 * @author hantsy
 */
@Configuration
@EnableWebFlux
class WebConfig implements ApplicationContextAware, WebFluxConfigurer {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.ctx = context;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry.viewResolver(thymeleafChunkedAndDataDrivenViewResolver());
    }

}
