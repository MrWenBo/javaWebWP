package com.spring.wen;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class ScrewDriver {
	//@Autowired
	@Resource
	private Header header;

	public void use() {
		System.out.println("Use header: " + header.getInfo());
		header.dowork();
	}

}
