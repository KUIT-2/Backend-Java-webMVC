package core.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JsonView implements View {

    //ObjectMapper를 통해 사용자에게 Json데이터 전달.
    @Override
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(model)); //addModel을 통해 추가한 model을 JSON으로 변환
    }

    //어떤 정보가 바인딩 돼 있는지 모르기 때문에, 모든 attribute의 name을 받아서 모델로 만듬, 그리고 mapper를 통해 매핑시켜줬으므로 민감한 정보가 포함돼 같이 넘어갈 가능성이 있음, 보안에 좋지 않음
//    private Map<String, Object> createModel(HttpServletRequest request) {
//        Enumeration<String> names = request.getAttributeNames();
//        Map<String, Object> model = new HashMap<>();
//        while(names.hasMoreElements()) {
//            String name = names.nextElement();
//            model.put(name, request.getAttribute(name));
//        }
//        return model;
//    }
}