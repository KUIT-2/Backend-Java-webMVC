package jwp;

import jwp.controller.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    HttpServletRequest request;
    HttpServletResponse response;
    private static final Map<String, Controller> controllers = new HashMap<>();
    private final Controller controller;

    public RequestMapper(HttpServletRequest request, HttpServletResponse response) {
        initControllers();
        this.request = request;
        this.response = response;
        controller = controllers.get(request.getRequestURI());
        System.out.println(request.getRequestURI());
    }

    private void initControllers() {
        controllers.put("/user/signup", new CreateUserController());
        controllers.put("/", new HomeController());
        controllers.put("/user/list", new ListUserController());
        controllers.put("/user/login", new LoginUserController());
        controllers.put("/user/logout", new LogoutUserController());
        controllers.put("/user/update", new UpdateUserController());
        controllers.put("/user/updateForm", new UpdateUserFormController());
    }

    public void proceed() throws IOException, ServletException {
        if (controller != null) {
            controller.execute(request, response);
            return;
        }
        System.out.println("Controller null");
        response.sendRedirect("/");
    }
}
