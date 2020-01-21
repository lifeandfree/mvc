package ru.innopolis.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * StorePasswordEncoder.
 *
 * @author Ilya_Sukhachev
 */
public class StorePasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
