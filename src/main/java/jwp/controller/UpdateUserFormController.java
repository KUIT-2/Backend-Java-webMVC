package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.RequestURL;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController implements Controller{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(userId));
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        User updateUser = new User(req.getParameter(userId),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        MemoryUserRepository.getInstance().findUserById(userId).update(updateUser);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(request.getMethod().equals("GET")) {
            doGet(request,response);
            return RequestURL.USER_UPDATE_FORM.getUrl();
        }
        doPost(request, response);
        return "redirect:" + RequestURL.USER_LIST.getUrl();
    }
}
