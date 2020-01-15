package ru.innopolis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController.
 *
 * @author lifeandfree
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/first")
    public String getIndex() {
        return "index";
    }
}
