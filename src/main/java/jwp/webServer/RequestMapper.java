package jwp.webServer;

import jwp.controller.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    private static final Map<String, Controller> controllers = new HashMap<>();
    private final Controller controller;

    public RequestMapper(HttpServletRequest request, HttpServletResponse response) {
        initController();
        this.request = request;
        this.response = response;
        controller = controllers.get(request.getRequestURI());
    }

    private void initController() {
        controllers.put(RequestURL.HOME.getUrl(), new HomeController());
        controllers.put(RequestURL.USER_SIGNUP.getUrl(),new CreateUserController());
        controllers.put(RequestURL.USER_LOGIN.getUrl(), new ListUserController());
        controllers.put(RequestURL.USER_LOGOUT.getUrl(), new LogoutUserController());
        controllers.put(RequestURL.USER_UPDATE.getUrl(), new UpdateUserController());
    }

    public void proceed() throws IOException, ServletException {
        if (controller != null) {
            controller.execute(request, response);
            return;
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}
