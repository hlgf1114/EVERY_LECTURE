package com.goldenbrothers.everylecture.Board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldenbrothers.everylecture.Board.model.BoardDTO;
import com.goldenbrothers.everylecture.Board.service.IBoardService;
import com.goldenbrothers.everylecture.Login.model.LoginDTO;

@Controller
public class BoardController {
	
	@Autowired 
	IBoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	// �Խ��� ������
	@RequestMapping(value = "/board/boardForm")
	public String go_boardList(Model model) {
		
		// ��ü ����Ʈ�� �����´�.
		ArrayList<BoardDTO> boardList = service.selectBoardAll();
		
		model.addAttribute("boardList", boardList);
		
		return "board/boardForm";
	}
	
	@RequestMapping(value = "/board/boardWrite")
	public String go_boardWrite(HttpSession session, Model model) {		
		return "board/boardWrite";
	}
	
	@ResponseBody
	@RequestMapping(value = "/board/writeContent")
	public String writeContent(@RequestParam HashMap<String, String> content, 
			HttpSession session) {
		
//		// ����� ������ �ҷ���
		LoginDTO user = (LoginDTO) session.getAttribute("uInfo");
		String userID = user.getUserID();
		String boardName = content.get("boardName");
		String boardText = content.get("boardText");
		
		// �Ķ���� �Է�
		BoardDTO dto = new BoardDTO();
		
		dto.setUserID(userID);
		dto.setBoardName(boardName);
		dto.setBoardText(boardText);
		
//		System.out.println(boardName + " " + boardText);
		
		
		String result = Integer.toString(service.insertBoard(dto));
		
		
		return null;
	}
	
	// ���� ��
	@RequestMapping(value = "/board/boardView/{boardID}")
	public String boardView(@PathVariable String boardID, Model model) {
		
		System.out.println(boardID);
		
		BoardDTO dto = service.selectOneBoard(boardID);
		
		model.addAttribute("board", dto);
		
		return "board/boardView";
	}
	
	@RequestMapping(value = "/board/boardRevise/{boardID}")
	public String boardRevise(@PathVariable String boardID, Model model) {
		
		
		return "board/boardRevise";
	}
}
