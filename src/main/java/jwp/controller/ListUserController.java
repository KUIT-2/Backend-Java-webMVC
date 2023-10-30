package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.RequestURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static jwp.RequestURL.*;

public class ListUserController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        //세션에 저장된 정보 가져오기
        HttpSession session = request.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
            request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return USER_LIST.getUrl();
        }
        return USER_LOGIN.getUrl();
    }
}
