package core.mvc.view;

import core.mvc.view.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JspView implements View {

    private String path;

    public JspView(String path) {
        this.path = path;
    }

    @Override
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        for (String key : model.keySet()) {
            req.setAttribute(key, model.get(key));
        }

        RequestDispatcher rd = req.getRequestDispatcher(path);
        rd.forward(req, resp);
    }

    public String getPath() {
        return path;
    }
}
