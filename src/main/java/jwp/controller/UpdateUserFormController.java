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

@WebServlet("/user/update.jsp")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = "1";
        String[] queryString = req.getQueryString().split("&");
        for (String query : queryString) {
            String[] input = query.split("=");
            if(input[0].equals("userId")) {
                userId = input[1];
            }
        }

        User user = MemoryUserRepository.getInstance().findUserById(userId);


        req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req,resp);
    }

    /*System.out.println(req.getQueryString());
        System.out.println(req.isRequestedSessionIdFromCookie());
        System.out.println(req.getCookies());*/
}
