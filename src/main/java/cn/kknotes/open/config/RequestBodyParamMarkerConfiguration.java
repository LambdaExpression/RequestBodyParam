package cn.kknotes.open.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lin
 * @date 2018/12/3
 */
@Configuration
public class RequestBodyParamMarkerConfiguration {
    @Bean
    public Marker requestBodyParamMarker() {
        return new Marker();
    }

    public static class Marker {
    }
}
