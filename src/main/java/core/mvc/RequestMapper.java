package core.mvc;

import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private static final Map<String, Controller> mapping = new HashMap<>();

    static {
        mapping.put("/user/signup", new CreateUserController());
        mapping.put("/", new HomeController());
        mapping.put("/user/list", new ListUserController());
        mapping.put("/user/login", new LoginController());
        mapping.put("/user/logout", new LogoutController());
        mapping.put("/user/updateForm", new UpdateFormController());
        mapping.put("/user/update", new UpdateUserController());

    }

    public Controller getController(String path) {
        // path라는 문자열에 해당하는 Controller 객체를 반환
        return mapping.get(path);
    }
}
