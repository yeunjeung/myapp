package com.yedam.myserver.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.todo.mapper.TodoMapper;
import com.yedam.myserver.todo.vo.TodoVO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoController {

	@Autowired TodoMapper mapper;
	
	@GetMapping("/todoSelect")
	public List<TodoVO> todoSelectList(TodoVO vo) {
		return mapper.findAll();
	}
		
	@PostMapping("/todoInsert")
	public TodoVO todoInsert(TodoVO vo) throws InterruptedException {
		 mapper.persist(vo);
		 return vo;
	}
	
	@GetMapping("/todoUpdate")
	public TodoVO todoUpdate(TodoVO vo) {
		 mapper.merge(vo);
		 return vo;
	}	
	@GetMapping("/todoDelete")
	public TodoVO todoDelete(TodoVO vo) {
		 mapper.remove(vo);
		 return vo;
	}		
}
