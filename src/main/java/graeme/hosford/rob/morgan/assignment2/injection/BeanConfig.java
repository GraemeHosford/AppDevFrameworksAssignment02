package graeme.hosford.rob.morgan.assignment2.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"graeme.hosford.rob.morgan"})
public class BeanConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(jdbcDatasource());
    }

    @Bean
    public DataSource jdbcDatasource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("schema.sql"
                        /* Can't add data.sql here yet because H2 shits the
                        bed when its used with JPA for some reason */
                )
                .build();
    }

}
