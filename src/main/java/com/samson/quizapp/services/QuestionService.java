package com.samson.quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samson.quizapp.Repository.QuestionRepository;
import com.samson.quizapp.models.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	

	public List<Question> getAllQuestion() {
		return (List<Question>) questionRepository.findAll();
		
	}
	
	
	

}
