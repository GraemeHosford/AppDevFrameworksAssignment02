package graeme.hosford.rob.morgan.assignment2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/register", "/index", "/registerUser", "/login", "/loginUser","/makebid/**")
                .permitAll()
                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
    }
}
