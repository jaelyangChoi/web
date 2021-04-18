package practice.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
	// 내장 톰캣 띄우면서 @SpringBootApplication 실행
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
