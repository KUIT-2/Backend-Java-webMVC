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

//@WebServlet("/user/list")
public class ListUserController extends HttpServlet implements Controller{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        System.out.println("value: "+value);

        if (value != null) {  // 로그인상태
            User user = (User) value;
            //session.setAttribute("myId", myUser.getUserId());
            System.out.println("getattribure user: "+value);
            System.out.println("myId: "+user.getUserId());
        }

        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
        rd.forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("listusercontroller POST");
    }
}
