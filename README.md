# java-webMVC

KUIT 서버 파트 - 4주차 미션 수행을 위한 레포지토리입니다.

미션 미션은 Backend-Java-webMVC 저장소를 Fork & Clone해 시작 자세한 내용은 디스코드 공지 참고 제출 방법 미션 제출 방법을 참고하여 제출




1. View와 Model을 갖는 ModelAndView 객체 추가
a. View render()시 모델 값 전달 인자 필요
    다음과 같이View클래스의 render메소드에 model인자 추가하는 방식으로 해결
   void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception;
b. model에 값을 추가하기 위해 메소드 추가 필요
    ModelAndView클래스에 다음과 같이 메소드 추가
   public ModelAndView addModel(String key, Object val){
   model.put(key,val);
   return this; //
   }
    
    return값으로 자기 자신의 객체를 반환해줌으로써 메소드체이닝이 가능하도록 하였다.
2. 각 View에 모델에 따른 render()수정
    JsonView클래스의 render는 다음과 같이 수정
   public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
   ObjectMapper mapper = new ObjectMapper();
   response.setContentType("application/json;charset=UTF-8");
   PrintWriter out = response.getWriter();
   out.print(mapper.writeValueAsString(model.values()));
   }

    원래 out.print(mapper.writeValueAsString(model));로 했었는데 새로고침이슈(트러블 슈팅에 서술할 예정, 아직 해결못함)
    때문에 저렇게 수정을 '시도해본거임'

    JspView의 render()메소드를 다음과 같이 수정

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

3. AbstractController(extends Controller) 생성

   public abstract class AbstractController implements Controller{
   public ModelAndView jspView(String viewName){
   return new ModelAndView(new JspView(viewName));
   };
   public ModelAndView jsonView(){
   return new ModelAndView(new JsonView());
   };
   }

    각각의 뷰들이 ModelandView안에 들어있는 형태이기 때문에 ModelAndView(view)형식으로 리턴함

4. Controller 구현체 로직 변경

    각각의 Controller들이 위에서 구현한 AbstractController클래스를 상속받도록 변경
    그리고 리턴값도 AbstractController클래스에서 구현한 메소드를 이용하여 리턴하도록 했다.


5. 트러블 슈팅(아직 미해결)

- 문제 : 질문란에 들어가서 답변을 작성하면 답변이 바로 화면에 반영이 안된다(새로고침을 하거나 나갔다가 다시 들어와야 반영)
- 해결시도
처음에 예제코드로준 mvc-step3-view 브랜치에서도 똑같은 현상이 발생하나 mvc-step2-ajax에서는 정상적으로 답변이 바로 반영이 되어서
그 브랜치의 jackson 패키지가 사용된 부분을 보았다.
그랬더니 거기서는 out.print(mapper.writeValueAsString(savedAnswer)) 이런식으로
writeValueAsString메소드에 'value'값에 해당되는 데이터가 인자로 전달되지
map자료구조 형태로 데이터가 전달되지 않기 때문에 이 문제인가 싶어서

out.print(mapper.writeValueAsString(model); -> out.print(mapper.writeValueAsString(model.values())); 이렇게 수정하고 실행해보았음
근데 그렇게 해도 안됨.....

DispatcherServlet에서 아예 처음부터 코드를 따라 들어가보았는데도
ajax브랜치에 비해 거치는 클래스가 많아졌을 뿐이지 jackson패키지가 적용이 안된다던가의 문제는 보이지 않았음
(전반적인 로직은 똑같았다는 말임)

그래서 이 부분을 해결하고 싶다......

-- 해결!!!---

뭐가 문제?

js파일이 문제였던거임

웹 페이지에서 개발자도구를 통해 로그를 찍어보았더니
var template = answerTemplate.format(json.answers.writer, new Date(json.answers.createdDate), json.answers.contents, json.answers.answerId, json.answers.answerId);
이 부분을 읽을 수가 없다고 함
그래서 생각을 해보니 우리가 답변을 입력받고 키 값을 'answer'로 주었지 'answers'로 주지 않았음
그래서 json.answers.xx 부분을 json.answer.xx로 바꾸고
out.print(mapper.writeValueAsString(model.values())); 이거에서 model.values()부분을 model로 바꾸기
이렇게 해야지 map자료구조 형식으로 쓰여져서 json.answer 형식으로 접근할 수 있다.
위 방식대로 고치니 문제가 해결이되었다 ~~~!!!
