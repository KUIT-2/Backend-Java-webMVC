package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MemoryUserRepository.getInstance().update(
                new User(
                        request.getParameter("userId"),
                        request.getParameter("password"),
                        request.getParameter("name"),
                        request.getParameter("email")
                )
        );
        String path = "/user/list";
        response.sendRedirect(path);
    }
}
