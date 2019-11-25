package graeme.hosford.rob.morgan.assignment2.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorHandlingController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/403")
    public String accessDenied() {
        /* Separate to be handled by SecurityConfig */
        return "403";
    }

    @GetMapping("/error")
    public String errorHandler(HttpServletResponse response) {
        if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return "404";
        }

        /* Generic unknown error page */
        return "errorpage";
    }
}
