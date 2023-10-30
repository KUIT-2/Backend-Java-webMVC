package jwp.controller;

import jwp.RequestURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jwp.RequestURL.*;

public class HomeController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return HOME.getUrl();
    }
}
