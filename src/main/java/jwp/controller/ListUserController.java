package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.controller.enums.Keys;
import jwp.controller.enums.RequestURL;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/list")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute(Keys.USER_SESSION_KEY.getValue());

        if (value != null) {
            req.setAttribute(Keys.USER_LIST_SESSION_KEY.getValue(), MemoryUserRepository.getInstance().findAll());
            RequestDispatcher rd = req.getRequestDispatcher(RequestURL.USER_LIST_JSP.getUrl());
            rd.forward(req, resp);
            return;
        }

        resp.sendRedirect(RequestURL.LOGIN_JSP.getUrl());

    }
}
