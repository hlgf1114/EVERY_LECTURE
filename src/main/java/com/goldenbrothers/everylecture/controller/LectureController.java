package com.goldenbrothers.everylecture.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goldenbrothers.everylecture.model.LectureDTO;
import com.goldenbrothers.everylecture.service.ILectureService;

@Controller
public class LectureController {
	
	@Autowired
	ILectureService service;
	
	private static final Logger logger = LoggerFactory.getLogger(LectureController.class);
	
	@RequestMapping(value = "/lecture/lectureList")
	public String lecture_list(Model model, HttpServletRequest request) {
		
		
		// 모든 강의를 가져온다.
		ArrayList<LectureDTO> lectureList = service.selectLectureAll();
		
		// 넣는다.
		model.addAttribute("lectureList", lectureList);
		
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		
		return "lecture/lecture_index";
	}

}
