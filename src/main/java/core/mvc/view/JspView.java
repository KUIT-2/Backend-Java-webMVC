package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JspView implements View{

    private final String viewName;
    private static final String REDIRECT_PREFIX = "redirect:";


    public JspView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //request.setAttribute("model",model); -> request에 아예 쌩으로 map자료구조를 집어넣는건 안되는가봄
        for (String key : model.keySet()) {
            request.setAttribute(key, model.get(key));
        }

        if (viewName.startsWith(REDIRECT_PREFIX)) {
            response.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
            return;
        }

        RequestDispatcher rd = request.getRequestDispatcher(viewName);
        rd.forward(request, response);
    }
}
