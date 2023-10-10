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

public class UpdateUserController extends HttpServlet implements Controller{

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
        else {
            req.setAttribute("user", user);
            resp.sendRedirect("/user/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        User updateUser = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        user.update(updateUser);
        MemoryUserRepository.getInstance().changeUserInfo(user);

        resp.sendRedirect("/user/list");
    }

}
