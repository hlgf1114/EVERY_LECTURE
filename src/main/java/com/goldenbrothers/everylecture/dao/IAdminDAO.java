package com.goldenbrothers.everylecture.dao;

import com.goldenbrothers.everylecture.model.AdminDTO;
import com.goldenbrothers.everylecture.model.LectureDTO;

public interface IAdminDAO {
	
	public AdminDTO selectOneAdmin(String userID);

}
