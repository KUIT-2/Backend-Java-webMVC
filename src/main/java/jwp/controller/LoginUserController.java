package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.http.HttpMethod;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginUserController extends HttpServlet implements Controller{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals(HttpMethod.GET)) {
            doGet(request, response);
        }
        if (request.getMethod().equals(HttpMethod.POST)) {
            doPost(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User loginUser = MemoryUserRepository.getInstance().findUserById(userId);
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", loginUser);
            RequestDispatcher rd = req.getRequestDispatcher("../home.jsp");
            rd.forward(req,resp);
        }
        else{
            RequestDispatcher rd = req.getRequestDispatcher("login_failed.jsp");
            rd.forward(req,resp);
        }
    }

}
