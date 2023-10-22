package core.mvc;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import jwp.controller.CreateUserController;
import jwp.controller.HomeController;
import jwp.controller.ListUserController;
import jwp.controller.LogOutController;
import jwp.controller.LoginController;
import jwp.controller.UpdateUserController;
import jwp.controller.UpdateUserFormController;

public class HandlerMapping {

    private final Map<String, Controller> mappings = new HashMap<>();

    public HandlerMapping() {
        init();
    }
    private void init() {
        mappings.put("/", new HomeController());
        mappings.put("/user/signup", new CreateUserController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogOutController());
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/updateForm", new UpdateUserFormController());

        mappings.put("/user/form", new ForwardController("/user/form.jsp"));
        mappings.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        mappings.put("/user/loginFailed", new ForwardController("/user/login_failed.jsp"));
    }

    public Controller getController(HttpServletRequest req) {
        return mappings.get(req.getRequestURI());
    }
}
