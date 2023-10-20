package jwp.controller;

import jwp.RequestURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        //세션 데이터 삭제
        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return "redirect:" + RequestURL.ROOT.getUrl();
    }
}
