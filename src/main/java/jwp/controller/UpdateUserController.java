package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserController extends AbstractController{

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/user/login";
        }
        if (user.getUserId().equals(req.getParameter("userId"))) {
            req.setAttribute("user",user);
            return "/user/updateForm";
        }
        else {
            return "redirect:/user/list";
        }
    }

    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp){

        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        User updateUser = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        user.update(updateUser);
        MemoryUserRepository.getInstance().changeUserInfo(user);
        return "redirect:/user/list";
    }

}
