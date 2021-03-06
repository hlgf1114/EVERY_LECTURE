package com.goldenbrothers.everylecture.Login.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.goldenbrothers.everylecture.Admin.dao.IAdminDAO;
import com.goldenbrothers.everylecture.Admin.model.AdminDTO;
import com.goldenbrothers.everylecture.Login.dao.ILoginDAO;
import com.goldenbrothers.everylecture.Login.model.LoginDTO;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	@Qualifier("ILoginDAO")
	ILoginDAO dao;

	@Override
	public LoginDTO selectOne(String userID) {
		// TODO Auto-generated method stub
		return dao.selectOne(userID);
	}

	@Override
	public ArrayList<LoginDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(LoginDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(LoginDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
