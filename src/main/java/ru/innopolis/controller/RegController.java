package ru.innopolis.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.db.model.User;
import ru.innopolis.service.RegistrationService;
import ru.innopolis.service.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reg")
public class RegController {

    private static final Logger logger = LogManager.getLogger(RegController.class.getName());

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView renderRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reg");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView userRegistration(@ModelAttribute(name = "userForm") @Validated UserDto userDto,
                                         BindingResult result, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("reg");
            modelAndView.addObject("result", result);
            return modelAndView;
        }

        registrationService.regUser(userDto);
        return modelAndView;
    }

    @ModelAttribute
    public User persistUser() {
        return new User();
    }

    @InitBinder(value = "userForm")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(registrationService);
    }

}
