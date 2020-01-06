package com.goldenbrothers.everylecture.service;

import java.util.ArrayList;

import com.goldenbrothers.everylecture.model.UserDTO;

public interface IMypageService {

	public UserDTO selectOne(String userID);
	public ArrayList<UserDTO>selectAll();
	public int insert(UserDTO dto);
	public int update(UserDTO dto);
	public int updateName(UserDTO dto);
	public int updatePW(UserDTO dto);
	public int delete(String id);

}