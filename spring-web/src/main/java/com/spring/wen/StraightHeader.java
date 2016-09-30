package com.spring.wen;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("header")
public class StraightHeader implements Header {
	@Value("${color}")
	private String color;
	@Value("${size}")
	private int size;
	
	@PostConstruct
	public void init() {
		System.out.println("init in the header");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy in the header");
	}

	public void dowork() {
		// TODO Auto-generated method stub
		System.out.println("do work with straight header");
	}

	public String getInfo() {
		// TODO Auto-generated method stub
		return "StraightHeader " + "color is:" + color + " size=" + size;
	}

}
