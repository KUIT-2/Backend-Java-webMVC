package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.controller.enums.Keys;
import jwp.controller.enums.Parameters;
import jwp.controller.enums.RequestURL;
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
        String userId = req.getParameter(Parameters.USER_ID.getValue());

        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null) {
            // setAttribute 코드가 없으면 updateForm.jsp에서 user 정보를 받아올 수 없음.
            req.setAttribute(Keys.USER_SESSION_KEY.getValue(), user);
            RequestDispatcher rd = req.getRequestDispatcher(RequestURL.UPDATE_FORM_JSP.getUrl());
            rd.forward(req, resp);
            return;
        }
        resp.sendRedirect(RequestURL.HOME.getUrl());
    }
}
