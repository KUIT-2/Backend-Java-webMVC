package core.mvc;

import core.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private View view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public ModelAndView addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws Exception {
        view.render(model, request, response);
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }
}

