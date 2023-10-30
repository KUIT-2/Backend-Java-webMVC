package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.RequestURL;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jwp.RequestURL.*;

public class CreateUserController implements Controller {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));
        MemoryUserRepository.getInstance().addUser(user);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if(request.getMethod().equals("GET")) {
            return USER_FORM.getUrl();
        }
        doPost(request, response);
        return LOGIN.getUrl();
    }
}
