package com.mycat.monoeshop.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycat.monoeshop.App;
import com.mycat.monoeshop.service.rest.AccountService;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void login(HttpServletResponse response, String username, String password) throws IOException {
		LOGGER.info("login handle "+username);
		String token = accountService.login(username, password);
		if (token != null) {
			Cookie cookie = new Cookie(App.SESSION_KEY, token);
			cookie.setMaxAge(24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
			LOGGER.info("redirect to main.html  ");
			response.sendRedirect("/main.html");
			//return "redirect:/main.html";
		} else {
			response.sendRedirect("/login.html");
			//return "redirect:";
		}
	}

	@RequestMapping(value = "/")
	public String index() {
		return "/main.html";
	}
}
