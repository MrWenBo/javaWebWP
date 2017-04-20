package com.spring.wen;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")

public class Control {
	@RequestMapping(value = "/spring")
	public void spring(HttpServletResponse response) throws IOException {
		response.getWriter().write("hello,spring web");
	}
}
