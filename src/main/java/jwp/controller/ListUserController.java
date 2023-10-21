package jwp.controller;

import core.db.MemoryUserRepository;
import org.apache.juli.logging.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/user/list/ controller 진입");
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        System.out.println(MemoryUserRepository.getInstance().findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
        rd.forward(req,resp);
    }
}
