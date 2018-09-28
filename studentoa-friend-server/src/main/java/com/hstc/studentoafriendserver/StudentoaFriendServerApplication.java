package com.hstc.studentoafriendserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hstc.studentoafriendserver.mapper")
public class StudentoaFriendServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentoaFriendServerApplication.class, args);
	}
}
