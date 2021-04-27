package practice.web.controller.dto;

// 웹 등록 화면에서 데이터를 전달 받을 폼 객체
public class MemberForm {
    private String name; //form으로 넘어온 데이터를 넣어준다(spring mvc의 기능)

    public String getName() {
        return name;
    }

    //spring이 input data의 name과 프로퍼티 이름을 보고 setter를 호출해서 넣는다.
    public void setName(String name) {
        this.name = name;
    }
}

/*
MemberForm은 화면에서 넘어온 Form 데이터를 받기 위한 목적.
따라서 컨트롤러에서만 사용하는 것이 좋다.

도메인 패키지는 가급적 HTML Form이나 UI에서 직접 넘어오는 데이터를 모르도록 설계를 해야 좋다.
이렇게 분리해두면 향후 UI나 넘어오는 정보가 변경되어도 해당 도메인을 변경하지 않아도 된다.
(물론 도메인을 변경해야 할 만큼 큰 변화가 있으면 모두 변경이 필요)
* */