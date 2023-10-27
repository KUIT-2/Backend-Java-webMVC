package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.naming.ldap.Control;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/user/list")
public class ListUserController extends HttpServlet implements Controller {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        if (value != null) {
            User user = (User) value;
            req.setAttribute("my", user);
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
            rd.forward(req,resp);
            return;
        }

        resp.sendRedirect("/");
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        if (value != null) {
            User user = (User) value;
            req.setAttribute("my", user);
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
            rd.forward(req,resp);
            return;
        }

        resp.sendRedirect("/");
    }
}
