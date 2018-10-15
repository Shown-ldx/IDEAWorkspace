package com.hstc.studentoateamserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hstc.studentoateamserver.mapper")
public class StudentoaTeamServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentoaTeamServerApplication.class, args);
	}
}
