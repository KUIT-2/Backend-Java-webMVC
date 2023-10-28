package jwp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/")
public class HomeController implements Controller {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
//        rd.forward(req,resp);

        return "/home.jsp";
    }
}
