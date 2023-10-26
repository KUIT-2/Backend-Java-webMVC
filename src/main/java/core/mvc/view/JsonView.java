package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JsonView implements View{
    @Override
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");

        // 캐시를 비활성화하기 위해 Cache-Control 헤더 설정
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);


        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(model.values()));
    }

    private Map<String, Object> createModel(HttpServletRequest request) {
        Enumeration<String> names = request.getAttributeNames();
        Map<String, Object> model = new HashMap<>();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            if(name.equals("model")) {
                model.put(name, request.getAttribute(name));
            }
        }
        return model;
    }
}
