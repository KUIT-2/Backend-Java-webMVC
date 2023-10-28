
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

//@WebServlet("/user/login")
public class LoginController implements Controller {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user == null || !password.equals(user.getPassword())) {
            resp.sendRedirect("/user/login_failed.jsp");
            return;
        }
        // 세션 정보 저장
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        resp.sendRedirect("/user/list");
    }

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user == null || !password.equals(user.getPassword())) {
//            resp.sendRedirect("/user/login_failed.jsp");
            return "/user/login_failed.jsp";
        }
        // 세션 정보 저장
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
//        resp.sendRedirect("/user/list");

        return "/user/list";
    }
}
