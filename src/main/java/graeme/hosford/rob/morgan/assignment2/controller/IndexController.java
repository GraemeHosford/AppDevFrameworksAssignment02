package graeme.hosford.rob.morgan.assignment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String indexMapping() {
        return "index";
    }

}
