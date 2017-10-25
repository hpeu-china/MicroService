package com.mycat.eshop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import com.zeroc.IceBox.Service;

public class AccountServiceBox implements Service {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceBox.class);
	protected ObjectAdapter _adapter;
	protected Identity id;

	@Override
	public void start(String name, Communicator communicator, String[] arg2) {
		LOGGER.info("start  servant :AccountService");
		// IceBox
		// 创建objectAdapter，这里和service同名
		_adapter = communicator.createObjectAdapter(name);
		// 创建servant
		com.zeroc.Ice.Object object = new AccountServiceI();
		id = Util.stringToIdentity(name);
		// _adapter.add(object, communicator.stringToIdentity(name));
		_adapter.add(object, id);
		// 激活
		_adapter.activate();
		LOGGER.info("start  servant success :AccountService");

	}

	@Override
	public void stop() {
		LOGGER.info("AccountServiceI stoped ,args ");
		_adapter.destroy();

	}

}