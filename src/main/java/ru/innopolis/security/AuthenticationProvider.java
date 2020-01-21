package ru.innopolis.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.innopolis.db.dao.UserDao;
import ru.innopolis.db.model.User;

import java.util.ArrayList;
import java.util.Collection;


public class AuthenticationProvider implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(AuthenticationProvider.class.getName());

    private UserDao userDAO;

    public AuthenticationProvider(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userDAO.findUserByLoginOrEmail(username);

            if(user == null) {
                throw new UsernameNotFoundException("Can't find user with username: \"" + username + "\"");
            }

            return new UserDetails() {

                User holder = user;

                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    ArrayList authorities = new ArrayList();
                    authorities.add(new GrantedAuthority() {
                        @Override
                        public String getAuthority() {
                            return holder.getRole().name();
                        }
                    });
                    return authorities;
                }

                @Override
                public String getPassword() {
                    return holder.getPassword();
                }

                @Override
                public String getUsername() {
                    return holder.getUsername();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return holder.isActive();
                }
            };
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
