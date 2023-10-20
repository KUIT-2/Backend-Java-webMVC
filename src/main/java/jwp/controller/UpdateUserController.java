package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet implements Controller{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        User updateUser = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"), req.getParameter("email"));
        user.update(updateUser);
        MemoryUserRepository.getInstance().changeUserInfo(user);

        resp.sendRedirect("/user/list");
    }

    @Override
    public void execute(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
    }
}