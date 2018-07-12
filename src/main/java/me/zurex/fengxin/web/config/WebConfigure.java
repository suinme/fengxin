package me.zurex.fengxin.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * @author zurex
 * @date 2018/6/11
 * Make life more fun
 */
@Configuration
public class WebConfigure {
    @Autowired
    WebHandlerExceptionResolver webHandlerExceptionResolver;

    @Bean
    public HandlerExceptionResolver exceptionHandler(){
        return webHandlerExceptionResolver;
    }
}
