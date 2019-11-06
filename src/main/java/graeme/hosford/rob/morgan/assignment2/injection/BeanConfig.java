package graeme.hosford.rob.morgan.assignment2.injection;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"graeme.hosford.rob.morgan"})
public class BeanConfig {

    @Bean
    public ServletWebServerFactory server() {
        return new TomcatServletWebServerFactory();
    }

}
