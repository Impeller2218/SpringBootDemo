package org.impelsys.SpringBootDemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.impelsys.SpringBootDemo.exception.CommentNotFoundException;
import org.impelsys.SpringBootDemo.model.Message;
import org.impelsys.SpringBootDemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RequestMapping("/comments")
@RestController("commentController")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@GetMapping(value="/list",produces="application/json")
	public List<Message> getComments(){
		List<Message> commentsList = commentService.getAllComments();
		return commentsList;
	}
	
	@GetMapping(value="/list1",produces="application/json")
	public ResponseEntity<List<Message>> getComments1(){
		List<Message> commentsList = commentService.getAllComments();
		ResponseEntity<List<Message>> responseEntity = new ResponseEntity<List<Message>>(commentsList,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value="/comment/{id}",produces="application/json")
	public ResponseEntity <Message> getComment(@PathVariable int id){
	Message comment = commentService.getComment(id);
	if(comment ==null)
		throw new CommentNotFoundException();
		ResponseEntity <Message> responseEntity = new ResponseEntity<Message>(comment,HttpStatus.OK);
		return responseEntity;
	}
	@ExceptionHandler(CommentNotFoundException.class)
	public void handlerForCommentsNotFound(HttpServletRequest req,HttpServletResponse res){
		System.out.println("ISSUE ISSUE ISSSUE ISSUE");
		
	}
}

