package ru.innopolis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello, World!");
        List<String> strings = Arrays.asList("ля-ля", "та-та", "гага");
        model.addAttribute("strings", strings);
        return "hello";
    };

}
