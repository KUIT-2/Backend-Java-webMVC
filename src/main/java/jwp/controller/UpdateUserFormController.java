package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jwp.model.User;

public class UpdateUserFormController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null && session.getAttribute("user").equals(user)) {
            req.setAttribute("user", user);
            return "/user/updateForm.jsp";
        }
        return "redirect:/";
    }
}
