package com.hstc.studentoauserserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hstc.studentoauserserver.mapper")
public class StudentoaUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentoaUserServerApplication.class, args);
	}
}
