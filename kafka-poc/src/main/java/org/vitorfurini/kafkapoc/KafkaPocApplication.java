package org.vitorfurini.kafkapoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vitorfurini.kafkapoc.util.JwtUtil;

@SpringBootApplication
public class KafkaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocApplication.class, args);
		String token = JwtUtil.generateToken("vitor-furini");
		System.out.println(token);
	}

}
