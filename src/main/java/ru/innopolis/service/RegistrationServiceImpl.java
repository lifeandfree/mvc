package ru.innopolis.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import ru.innopolis.db.dao.UserDao;
import ru.innopolis.db.model.User;
import ru.innopolis.service.dto.UserDto;

import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class.getName());
    private UserDao userDao;

    public RegistrationServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail());
        userDao.addUser(user);
        user.setId(user.getId());
        return userDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userForm = (UserDto) target;
        if (userForm.getUsername().isEmpty()) {
            logger.error("username is empty");
            errors.rejectValue("username", "username.empty", "Укажите логин");
        }

        if(errors.hasErrors()) return;

        if (!userForm.getPassword().equals(userForm.getRepeatpassword())) {
            logger.error("passwords mismatch ");
            errors.rejectValue("repeatpassword", "password.mismatch", "Пароли не совпадают");
        }

        if(errors.hasErrors()) return;
    }

}
