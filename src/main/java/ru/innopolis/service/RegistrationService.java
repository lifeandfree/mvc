package ru.innopolis.service;

import org.springframework.validation.Validator;
import ru.innopolis.service.dto.UserDto;

public interface RegistrationService extends Validator {
    UserDto regUser(UserDto userDto) ;

}
