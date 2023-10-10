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
import java.io.IOException;

public class CreateUserController extends HttpServlet implements Controller{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (HttpMethod.GET.isEqual(request.getMethod())) {
            doGet(request, response);
        }
        if (HttpMethod.POST.isEqual(request.getMethod())) {
            doPost(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/user/form.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().addUser(user);
        System.out.println("??");
        resp.sendRedirect("/");
    }
}
