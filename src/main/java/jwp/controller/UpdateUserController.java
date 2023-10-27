package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jwp.model.User;

public class UpdateUserController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        MemoryUserRepository.getInstance().findUserById(req.getParameter("userId")).update(new User(
                req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email")
        ));
        return "redirect:/user/list";
    }
}
