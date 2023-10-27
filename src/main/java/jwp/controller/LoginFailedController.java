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

//@WebServlet("/user/login_failed")
public class LoginFailedController extends HttpServlet implements Controller{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/user/login_failed.jsp");
        rd.forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//name 태그로 넣어야됨!
        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        System.out.println(user);
        if (user == null) {
            resp.sendRedirect("/user/login_failed");
            return;
        }
        if (user.matchPassword(req.getParameter("password"))) {
            //로그인 성공
            System.out.println("로그인 성공!");
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }
        resp.sendRedirect("/");

    }

}

