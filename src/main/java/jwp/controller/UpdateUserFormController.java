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

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            RequestDispatcher rd = req.getRequestDispatcher("user/login");
            rd.forward(req,resp);
        }
        if (user.getUserId().equals(req.getParameter("userId"))) {
            req.setAttribute("user",user);
            RequestDispatcher rd = req.getRequestDispatcher("updateForm.jsp");
            rd.forward(req,resp);
        }
        req.setAttribute("user",user);
        resp.sendRedirect("/user/list");
    }
}
