package com.chason.nas.bountyhunter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chason.nas.bountyhunter.mapper")
public class BountyHunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BountyHunterApplication.class, args);
	}
}
