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
        controllers.put(RequestURL.USER_LOGIN.getUrl(), new LoginUserController());
        controllers.put(RequestURL.USER_LIST.getUrl(), new ListUserController());
        controllers.put(RequestURL.USER_LOGOUT.getUrl(), new LogoutUserController());
        controllers.put(RequestURL.USER_UPDATE.getUrl(), new UpdateUserController());
    }

    public String proceed(){
        if (controller != null) {
            String url = controller.execute(request, response);
            return url;
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
    }
}
