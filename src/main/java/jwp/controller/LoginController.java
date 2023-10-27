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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String userPassword = req.getParameter("password");

        User loginUser = MemoryUserRepository.getInstance().findUserById(userId);

        if (loginUser.matchPassword(userPassword)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", loginUser);

            RequestDispatcher rd = req.getRequestDispatcher("/");
            rd.forward(req,resp);
        } else {

        }

    }

}
