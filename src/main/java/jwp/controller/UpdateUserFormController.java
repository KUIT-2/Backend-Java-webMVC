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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(Parameters.USER_ID.getValue());
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null) {
            HttpSession session = req.getSession();
            Object value = session.getAttribute(Keys.USER_SESSION_KEY.getValue());
            if (value != null) {
                User sessionUser = (User) value;
                if (sessionUser.isSameUser(user)) {
                    // setAttribute 코드가 없으면 updateForm.jsp에서 user 정보를 받아올 수 없음.
                    req.setAttribute(Keys.USER_SESSION_KEY.getValue(), user);
                    RequestDispatcher rd = req.getRequestDispatcher(RequestURL.UPDATE_FORM_JSP.getUrl());
                    rd.forward(req, resp);
                    return;
                }

                printInvalidAccessAlert(resp);
                return;
            }

        }
        resp.sendRedirect(RequestURL.HOME.getUrl());
    }

    private void printInvalidAccessAlert(HttpServletResponse resp) throws IOException {
        String pageUrl = RequestURL.USER_LIST.getUrl();
        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html; charset=UTF-8");
        writer.println("<script>alert('다른 유저의 정보를 수정할 수 없습니다.'); location.href='" + pageUrl + "';</script>");
        writer.close();
    }
}
