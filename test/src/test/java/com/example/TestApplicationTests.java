package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.MysqlDAO;

@SpringBootTest
class TestApplicationTests {
	@Autowired
	MysqlDAO dao;
	
	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		dao.now();
	}
}
