package jwp.controller;

import jwp.RequestURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return RequestURL.HOME.getUrl();
    }
}
