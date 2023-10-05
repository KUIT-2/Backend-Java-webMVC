package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import org.apache.catalina.users.MemoryUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");


        if (isLoginSuccess(userId, password)) {
            resp.sendRedirect("/home.jsp");
            return;
        }
        resp.sendRedirect("/user/loginFailed.jsp");

    }

    private boolean isLoginSuccess(String userId, String password) {
        User user = memoryUserRepository.findUserById(userId);
        if (user == null) return false;

        return (user.isSameUser(userId) && user.matchPassword(password));
    }
}
