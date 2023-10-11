package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUserController extends AbstractController{

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp){
//        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
//        rd.forward(req,resp);
        return "/user/login";
    }

    @Override
    protected String doPost(HttpServletRequest req, HttpServletResponse resp){
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User loginUser = MemoryUserRepository.getInstance().findUserById(userId);
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", loginUser);
            return "redirect:/";
        }
        else{
            return "/user/login_failed";
        }
    }

}
