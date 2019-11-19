package graeme.hosford.rob.morgan.assignment2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource datasource;

    public SecurityConfig(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/")
                .usernameParameter("email");

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery("SELECT u.userEmail, u.userPassword, u.userEnabled FROM User u WHERE u.userEmail=?")
                .authoritiesByUsernameQuery("SELECT r.roleEmail, r.roleDescription FROM Role r WHERE r.roleEmail=?");*/

        auth.inMemoryAuthentication().withUser("graeme.hosford@mycit.ie")
                .password(passwordEncoder().encode("password"))
                .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
