package graeme.hosford.rob.morgan.assignment2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource datasource;

    public SecurityConfig(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index", "/register", "/registerUser", "/job/**")
                .permitAll()
                .antMatchers("/api/**").hasRole("API")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .and().httpBasic()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().logout().logoutSuccessUrl("/").permitAll();

        /* Registering purposely does not login automatically.
         * This is to make checking login functionality more convenient without having
         * to logout first */

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery("SELECT u.email, u.password, u.enabled FROM User u WHERE u.email=?")
                .authoritiesByUsernameQuery("SELECT r.email, r.description FROM Role r WHERE r.email=?");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
