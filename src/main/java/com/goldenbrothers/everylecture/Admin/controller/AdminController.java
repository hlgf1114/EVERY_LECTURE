package com.goldenbrothers.everylecture.Admin.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.goldenbrothers.everylecture.Admin.model.AdminDTO;
import com.goldenbrothers.everylecture.Admin.service.IAdminService;
import com.goldenbrothers.everylecture.Lecture.model.LectureDTO;
import com.goldenbrothers.everylecture.Utils.FileUtil;

@Controller
public class AdminController {
	
	@Autowired
//	@Qualifier("IAdminService")
	IAdminService service;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//------------------------------ admin �α��� ------------------------------
	
	@RequestMapping(value = "/admin/adminLogin")
	public String goLoginAdmin(HttpSession session, Principal principal) {		
		// ����� ���� ��������
		String userID = principal.getName();
		System.out.println(userID);
		AdminDTO dto = new AdminDTO();
		try {
			
			if(userID != null)
				dto =  service.selectOneAdmin(userID);
			
			session.setAttribute("aInfo", dto);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("error!!!");
		}
		
		
		return "redirect:/";
	}
	
	// ���� ����
	@ResponseBody
	@RequestMapping(value = "/admin/uploadLecutureInfo")
	public String upload_lecture_info(MultipartRequest multipartRequest, 
			@RequestParam HashMap<String, Object> info,
			HttpSession session, HttpServletRequest request) {
		// ajax���� ���� ������ �޴´�.
		MultipartFile file = multipartRequest.getFile("lectureImg");
		
		// ���� ���ε� ���� ��ü
		FileUtil fileUtil = new FileUtil();
		
		// ���� �����ϰ� ���� ��θ� ��ȯ
		String fileLocation = fileUtil.saveImage(file, request);
		
		LectureDTO dto = new LectureDTO();
		
		// dto ���� �غ�
		AdminDTO user = (AdminDTO) session.getAttribute("aInfo");
		
		String adminID = user.getAdminID();
		String lectureName = (String) info.get("lectureName");
		String lectureExplain = (String) info.get("lectureExplain");
		String lectureImgName = file.getOriginalFilename();
		String lectureImgPath = fileLocation;
		
		// dto�� ����
		dto.setAdminID(adminID);
		dto.setLectureName(lectureName);
		dto.setLectureExplain(lectureExplain);
		dto.setLectureImgName(lectureImgName);
		dto.setLectureImgPath(lectureImgPath);
		
		// �����ͺ��̽��� ����
		String result = Integer.toString(service.uploadLecture(dto));
		
		
		return result;
	}
	
	// ���� ����
	@ResponseBody
	@RequestMapping(value = "/admin/deleteLecture")
	public String delete_lecture(@RequestParam String lectureID, HttpServletRequest request) {
		
		System.out.println(lectureID);
		
		// ���� ���� �ҷ���
		LectureDTO lecture = service.selectOneLecture(lectureID);
		String filePath = lecture.getLectureImgPath();
		
		System.out.println(filePath);
		
		// ���� ����
		String result = Integer.toString(service.deleteOneLecture(lectureID));
		
		// ���� �̹��� ����
		FileUtil fileUtil = new FileUtil();
		fileUtil.deleteImage(filePath, request);
		
		return result;
	}
	

	@RequestMapping(value = "/admin/goDeleteLecture")
	public String go_delete_lecture(Model model) {
		
		// ��� ���Ǹ� �����´�.
		ArrayList<LectureDTO> lectureList = service.selectLectureAll();
		
		// �ִ´�.
		model.addAttribute("lectureList", lectureList);
		
		return "admin/lecture_index_admin";
	}
	
}
