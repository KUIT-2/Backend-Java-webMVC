package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutUserController extends AbstractController{


    //세션 없애고 home으로 redirect
    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return "redirect:/";
    }

    @Override
    String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
