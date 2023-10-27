package jwp.controller;


import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet implements Controller{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        //로그인된 상태에서 정보 바뀌면 그 정보로 user 바꿔줌
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        System.out.println("id: "+ req.getParameter("userId"));
        System.out.println("updatecon");
        resp.sendRedirect("/user/list");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
