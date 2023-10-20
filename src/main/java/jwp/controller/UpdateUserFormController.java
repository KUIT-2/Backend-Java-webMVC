package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet implements Controller {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String userId = req.getParameter("userId");
        final User user = MemoryUserRepository.getInstance().findUserById(userId);

        req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req,resp);
    }

    /*  이전에 좀 더 어렵게 작성한 코드
    String[] queryString = req.getQueryString().split("&");
    for (String query : queryString) {
        String[] input = query.split("=");
            if(input[0].equals("userId")) {
                userId = input[1];
            }
        }
    */

    @Override
    public void execute(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
    }
}
