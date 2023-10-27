package jwp.controller;

import org.apache.jasper.tagplugins.jstl.core.Url;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet implements Controller{

    private static final Map<String, Controller> controllers = new HashMap<>();
    private Controller controller;
    public DispatcherServlet() {
        initControllers();
    }

    private void initControllers() {
        controllers.put("/user/signup", new CreateUserController());
        controllers.put("/", new HomeController());
        controllers.put("/user/list", new ListUserController());
        controllers.put("/user/login", new LoginController());
        controllers.put("/user/login_failed", new LoginFailedController());
        controllers.put("/user/logout", new LogoutController());
        controllers.put("/user/userList", new ListUserController());
        controllers.put("/user/update", new UpdateUserController());
        controllers.put("/user/updateForm", new UpdateUserFormController());

    }



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = controllers.get(req.getRequestURI());

        if(controller != null) {
            System.out.println("Get controller: "+controller);
            controller.doGet(req, resp);
        }

/*        get(req.getRequestURI());하면
                /user/signup
                /user/css/styles.css
                /user/js/scripts.js
                이렇게 다 불러와지는데 왜이러지
                */

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = controllers.get(req.getRequestURI());

        if(controller != null) {
            System.out.println("Post controller: "+controller);
            controller.doPost(req, resp);
        }
    }


}
