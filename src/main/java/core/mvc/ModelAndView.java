package core.mvc;

import core.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private final View view;
    private final Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        view.render(model, req, resp);
    }

    public ModelAndView addModelElement(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
