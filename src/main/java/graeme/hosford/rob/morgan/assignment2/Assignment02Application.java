package graeme.hosford.rob.morgan.assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * App Dev. Frameworks Assignment 02
 * Developed by Graeme Hosford (R00147327) and Robert Morgan (R00132949)
 * */

@EnableScheduling
@SpringBootApplication
public class Assignment02Application {

    public static void main(String[] args) {
        /*
         * Some classes contain unused constructors, getters and setters.
         * Some of these seem to be used by Spring or Thymeleaf because
         * removing them can cause errors. So easy option taken and they are
         * left in without checking which are needed and which are not.
         * */
        SpringApplication.run(Assignment02Application.class, args);
    }

}
