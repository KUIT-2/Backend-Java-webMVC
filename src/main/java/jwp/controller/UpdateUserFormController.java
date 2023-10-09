package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet implements Controller {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("updateformcon: " + req.getParameter("userId"));

        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        //req.setAttribute("myuser", user);
        System.out.println("print: " + user.getUserId());

        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req, resp);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = new User(req.getParameter("userId"),
//                req.getParameter("password"),
//                req.getParameter("name"),
//                req.getParameter("email"));
//
//        MemoryUserRepository.getInstance().changeUserInfo(user);
//
//
//        resp.sendRedirect("/user/list");
    }
}
