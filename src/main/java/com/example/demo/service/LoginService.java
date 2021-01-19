package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DokotubuConstant;
import com.example.demo.dao.LoginDaoInterface;

@Service
public class LoginService implements LoginServiceInterface {

	private LoginDaoInterface loginDaoInterface;

	@Autowired
	public LoginService( LoginDaoInterface loginDaoInterface) {
		this.loginDaoInterface = loginDaoInterface;
	}

	@Override
	public DokotubuConstant login(String account, String password) {
		try {

			loginDaoInterface.login(account, password).get();

		} catch (NullPointerException e) {
			return DokotubuConstant.IS_NOT_APPROVAL;
		}

		return DokotubuConstant.IS_APPROVAL;
	}

}
