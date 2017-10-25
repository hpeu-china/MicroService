package com.mycat.eshop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycat.eshop.intf.model.Account;
import com.mycat.eshop.intf.service.AccountService;
import com.zeroc.Ice.Current;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
public class AccountServiceI implements AccountService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceI.class);

	@Override
	public Account login(String name, String password, Current current) {
		LOGGER.info("account login, username: {}, password: {}", name, password);
		Account ac = null;
		if (name.equals("guest") && password.equals("111111")) {
			ac = new Account();
			ac.name = name;
		}
		return ac;
	}

}
