package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListUserController extends AbstractController{

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/user/login";
        }
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "/user/list";
    }

    @Override
    String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
