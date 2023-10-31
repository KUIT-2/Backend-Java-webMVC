package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private final View view;
    Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view){
        this.view = view;
    }

    public ModelAndView addModel(String name, Object answer){
        model.put(name, answer);
        return this;
        // 왜 this를 return 하냐? --> AddAnswerController 에서 return 값을 얻어내기 위해서
    }
    public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        view.render(model, req, resp);
    }
}
