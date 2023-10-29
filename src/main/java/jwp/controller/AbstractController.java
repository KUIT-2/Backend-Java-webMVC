package jwp.controller;

import jwp.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class AbstractController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        if (HttpMethod.GET.isEqual(request.getMethod())) {
            return doGet(request, response);
        }
        return doPost(request, response);
    }

    abstract String doGet(HttpServletRequest request, HttpServletResponse response);

    abstract String doPost(HttpServletRequest request, HttpServletResponse response);
}
