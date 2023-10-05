package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("실행");
        String login_id = req.getParameter("userId");
        String login_password = req.getParameter("password");
        User user = MemoryUserRepository.getInstance().findUserById(login_id);

        if(user.matchPassword(login_password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            System.out.println("로그인성공!");
        }
        resp.sendRedirect("/");
    }
}
