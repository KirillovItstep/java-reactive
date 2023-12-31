package org.itstep.responseheaders.functional.routers;

import org.itstep.responseheaders.functional.handlers.ResponseHeaderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ResponseHeadersRouterFunctions {

    @Bean
    public RouterFunction<ServerResponse> responseHeaderRoute(@Autowired ResponseHeaderHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/functional-response-header/single-handler"), handler::useHandler);
    }
}
