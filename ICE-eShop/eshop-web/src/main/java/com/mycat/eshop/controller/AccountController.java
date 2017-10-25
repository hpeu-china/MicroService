package com.mycat.eshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycat.eshop.App;
import com.mycat.eshop.intf.model.Account;
import com.mycat.eshop.intf.service.AccountServicePrx;

import io.mycat.ice.utils.ICEClientUtil;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response, String username, String password)
			throws IOException {
		LOGGER.info("login handle " + username);
		AccountServicePrx accountServicePrx = (AccountServicePrx) ICEClientUtil.getSerivcePrx(AccountServicePrx.class);
		Account account = accountServicePrx.login(username, password);
		if (account != null) {
			request.getSession().setAttribute(App.SESSION_KEY, account);
			LOGGER.info("redirect to main.html  ");
			response.sendRedirect("/main.html");
			// return "redirect:/main.html";
		} else {
			response.sendRedirect("/login.html");
			// return "redirect:";
		}
	}

	@RequestMapping(value = "/")
	public String index() {
		return "/main.html";
	}
}
