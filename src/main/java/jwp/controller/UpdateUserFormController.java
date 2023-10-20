package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null) {
            req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(req.getParameter("userId")));

            RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");

            rd.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String userPassword = req.getParameter("password");
        String userName = req.getParameter("name");
        String userEmail = req.getParameter("email");

        User updateUser = new User(userId, userPassword, userName, userEmail);

        MemoryUserRepository.getInstance().findUserById(req.getParameter("userId")).update(updateUser);

        resp.sendRedirect("/user/list");
    }
}
