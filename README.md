# java-webMVC

KUIT 서버 파트 - 4주차 미션 수행을 위한 레포지토리입니다.

미션 미션은 Backend-Java-Tomcat 저장소를 Fork & Clone해 시작 자세한 내용은 디스코드 공지 참고 제출 방법 미션 제출 방법을 참고하여 제출

요구사항 1-1
1,2는 노션에서 명시한대로 해주었음
3은 HomeController따로 파주어서 Dispatcher(솔직히 이게 아직 뭔지는 모르겠음)에 home.jsp매핑해주고
forward작업 수행

요구사항 1-2
header.jspf, nevigation.jspf따로 만들어서 중복된 html코드 넣어주고
노션에서 알려준 메소드 그대로 적용

요구사항 1-3
여기서 트러블 슈팅
UpdateUserFormController를 만들어서 update.form에 매핑을 시켜주었는데
쿼리 스트링을 못읽어옴(실제로 sysout사용해서 출력을 해보았지만 소용x)
알고보니 controller자체가 실행이 안됨
why?
list.jsp에서 수정 버튼을 누를때 a태그 링크에 updateform.jsp라고 써버렸던 거임
그래서 controller상단에 위치한 servlet어노테이션 주소와 매칭이 안되어서 실행이 안되었던 거임
이번 트러블 슈팅을 통해 원래는 .jsp가 html의 확장(? 자바코드가 들어갈 수 있는) 버전이라고
잘못생각했었는데 그게 아님을 깨닫게됨 jsp와 html은 애초에 결이 달랐던 것 같음
이거에 대해서 추후에 공부가 필요할 듯

String name = req.getParameter("username"); // 이런식으로 쿼리 파라미터 가져오고
req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(name)); // finduserById가 보니깐
user를 가져오는 거여서 적용

아 그리고 유저 정보 가져오면 Email 부분에 ${내가 입력한 이메일 주소} + 'id =' 이런식으로 뜨는데
'id = '이 어디서 뜨는지 모르겠음

요구사항 3-2단계
이거 근데 별 다른 코딩안해도 요구사항대로 동작하는 것 같은데 왜 그런지 모르겠음

------------------여기까지가 구현한 것------------------------------------

[//]: # (요구사항 1-3-2)

[//]: # (3-1에서 했던 거랑 비슷한 로직인 것 같음)

4,5도 마찬가지로 지금까지 했던 거에서 조금 응용한다는 것 뿐이지
새로운 개념이 들어와있지는 않는듯???(착각일수도..........)