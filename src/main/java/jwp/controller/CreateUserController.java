package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController extends AbstractController {

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) {
        return "/user/form";
    }

    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp){
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().addUser(user);
        System.out.println("??");
        return "redirect:/";
    }
}
