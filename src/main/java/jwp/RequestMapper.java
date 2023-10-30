package jwp;

import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;

import static jwp.RequestURL.*;

public class RequestMapper {
    private Map<String, Controller> requestMapper;

    public RequestMapper() {
        requestMapper = new HashMap<String, Controller>();
        requestMapper.put(USER_SIGNUP.getUrl(), new CreateUserController());
        requestMapper.put(ROOT.getUrl(), new HomeController());
        requestMapper.put(USER_LIST.getUrl(), new ListUserController());
        requestMapper.put(USER_LOGIN.getUrl(), new LoginController());
        requestMapper.put(USER_LOGOUT.getUrl(), new LogoutController());
        requestMapper.put(USER_UPDATE.getUrl(), new UpdateUserFormController());
    }
    public Controller getController(String path) {
        return requestMapper.get(path);
    }
}
