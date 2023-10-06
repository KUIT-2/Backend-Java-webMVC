package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.controller.enums.Parameters;
import jwp.controller.enums.RequestURL;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/signup")
public class CreateUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter(Parameters.USER_ID.getValue()),
                req.getParameter(Parameters.PASSWORD.getValue()),
                req.getParameter(Parameters.NAME.getValue()),
                req.getParameter(Parameters.EMAIL.getValue()));

        MemoryUserRepository.getInstance().addUser(user);
        resp.sendRedirect(RequestURL.USER_LIST.getUrl());
    }
}
