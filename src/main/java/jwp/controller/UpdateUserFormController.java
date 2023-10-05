package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateform")
public class UpdateUserFormController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("실행");
        String name = req.getParameter("username");
        req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(name));
        RequestDispatcher rd = req.getRequestDispatcher("/user/updateform.jsp");
        rd.forward(req, resp);
    }
}

