package graeme.hosford.rob.morgan.assignment2;

import graeme.hosford.rob.morgan.assignment2.injection.BeanConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Assignment2Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        context.close();
    }

}
