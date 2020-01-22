package ru.innopolis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.service.dto.IndexDto;

/**
 * IndexController.
 *
 * @author lifeandfree
 */
@Controller
//@RestController //(@Controller &&  @ResponseBody)
public class IndexController {

    //@GetMapping
    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String getIndex() {
//        if (true) {
//            throw new RuntimeException("111");
//        }
        return "index";
    }

    @RequestMapping(value = "/two")
    @ResponseBody
    public String getTwo() {
        return new IndexDto("name", "age").toString();
    }
}
