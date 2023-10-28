package core.mvc;

import core.mvc.view.View;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

    private View view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public ModelAndView addObject(String key, Object value) {
        model.put(key, value);
        return this;  // 메소드 체이닝을 위해 자신을 반환
    }

    public View getView() {
        return view;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
