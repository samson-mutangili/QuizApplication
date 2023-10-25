package com.samson.quizapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.samson.quizapp.Repository.QuestionRepository;
import com.samson.quizapp.models.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	

	public ResponseEntity<List<Question>> getAllQuestion() {
		try {
			return new ResponseEntity<>((List<Question>)questionRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		
		try {
			return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		
		questionRepository.save(question);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);

	}
	

}
