package io.goorm.mini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.goorm.mini.mapper")
@MapperScan("io.goorm.mini.dynamic.mapper")
public class MiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniApplication.class, args);
	}

}
