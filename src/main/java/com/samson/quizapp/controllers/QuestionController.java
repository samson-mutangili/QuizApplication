package com.samson.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samson.quizapp.models.Question;
import com.samson.quizapp.services.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public List<Question> getAllQuestions() {
		return  questionService.getAllQuestion();
	}
	
	public void addQuestion(QuestionController question) {
		
	}
}
