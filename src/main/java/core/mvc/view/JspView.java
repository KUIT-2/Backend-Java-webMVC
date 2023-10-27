package core.mvc.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

public class JspView implements View {

    private String viewName;
    private static final String REDIRECT_PREFIX = "redirect:";

    public JspView(String viewName) {
        this.viewName = viewName;
    }
    @Override
    public void render(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> model) throws Exception {
        model.forEach((key, value) -> {
            req.setAttribute(key, value);
        });

        if (viewName.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher(viewName);
        rd.forward(req, resp);
    }
}
