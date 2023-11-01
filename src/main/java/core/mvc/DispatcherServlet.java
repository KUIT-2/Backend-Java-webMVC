package core.mvc;

import core.mvc.view.ModelAndView;
import core.mvc.view.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private RequestMapping requestMapping;

    @Override
    public void init(){
        requestMapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Controller controller = requestMapping.getController(req);
        if (controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.setSession(req.getSession());    // 세션 추가
        Map<String, String> params = getParams(req);    // request에서 파라미터 전부 가져와서 map에 담아줌
        try {
            ModelAndView mav = controller.execute(params);
            mav.render(req,resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }

    private Map<String, String> getParams(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}
