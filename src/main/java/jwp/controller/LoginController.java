package jwp.controller;

import jwp.RequestURL;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController implements Controller{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(request.getMethod().equals("GET")) {
            return RequestURL.USER_LOGIN.getUrl();
        }

        //doPost
        User user = new User(request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));
        // 세션 정보 저장
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "redirect:" + RequestURL.ROOT.getUrl();
    }
}
