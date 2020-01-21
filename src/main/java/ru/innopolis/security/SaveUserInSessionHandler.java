package ru.innopolis.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import ru.innopolis.db.dao.UserDao;
import ru.innopolis.db.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * SaveUserInSessionHandler.
 *
 * @author Ilya_Sukhachev
 */
public class SaveUserInSessionHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserDao userDAO;
    private static final Logger logger = LogManager.getLogger(SaveUserInSessionHandler.class.getName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        String targetUrl = null;
        if (savedRequest != null) {
            //получаем урл, на который хотел попасть пользователь до авторизации
            targetUrl = savedRequest.getRedirectUrl();
        }

        clearSession(request);
        User user = null;
        try {
            user = userDAO.findUserByLogin(authentication.getName());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //TODO обработка ситуации проблем с получением юзера из бд
            response.sendRedirect("/login");
            return;
        }

        request.getSession().setAttribute("user", user);

        if(targetUrl != null) {
            response.sendRedirect(targetUrl);
        } else {
            response.sendRedirect("/first");
        }
    }

    private void clearSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.invalidate();
    }
}
