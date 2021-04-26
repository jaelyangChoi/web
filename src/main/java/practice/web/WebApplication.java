package practice.web;
//이 패키지 하위 파일을 뒤져 컴포넌트 스캔
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//spring이 뜰 때 컨테이너가 생긴다.
@SpringBootApplication
public class WebApplication {
	// 내장 톰캣 띄우면서 @SpringBootApplication 실행
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
