package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.controller.enums.Keys;
import jwp.controller.enums.Parameters;
import jwp.controller.enums.RequestURL;
import jwp.model.User;
import org.apache.catalina.users.MemoryUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(Parameters.USER_ID.getValue());
        String password = req.getParameter(Parameters.PASSWORD.getValue());

        if (isLoginSuccess(userId, password)) {
            HttpSession session = req.getSession();
            session.setAttribute(Keys.USER_SESSION_KEY.getValue(), memoryUserRepository.findUserById(userId));
            resp.sendRedirect(RequestURL.HOME_JSP.getUrl());
            return;
        }
        resp.sendRedirect(RequestURL.LOGIN_FAILED_JSP.getUrl());
    }

    private boolean isLoginSuccess(String userId, String password) {
        User user = memoryUserRepository.findUserById(userId);
        if (user == null) return false;

        return (user.isSameUser(userId) && user.matchPassword(password));
    }
}
