package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends AbstractController{

    @Override
    protected String doGet(HttpServletRequest req, HttpServletResponse resp){
        return "/home";
    }

    @Override
    protected String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
