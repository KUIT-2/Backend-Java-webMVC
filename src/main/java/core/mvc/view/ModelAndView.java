package core.mvc.view;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private View view;
    private final Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public ModelAndView addData(String key, Object value) {
        model.put(key, value);
        return this;
    }
}
