package jwp.controller;

import jwp.controller.enums.RequestURL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 요구사항 1 : HomeController
 *  HomeController가 “/” url을 받아 home.jsp를 forward 하게끔 변경한다.
 * */
@WebServlet("/")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(RequestURL.HOME_JSP.getUrl());
        rd.forward(req,resp);
    }
}
