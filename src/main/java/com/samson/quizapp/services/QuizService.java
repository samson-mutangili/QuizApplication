package com.samson.quizapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.samson.quizapp.Repository.QuestionRepository;
import com.samson.quizapp.Repository.QuizRepository;
import com.samson.quizapp.models.Question;
import com.samson.quizapp.models.QuestionWrapper;
import com.samson.quizapp.models.Quiz;
import com.samson.quizapp.models.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	QuestionRepository questionRepository;

	public ResponseEntity<String> createQuiz(String category, int numQuestions, String title) {
		
		//get the questions randomly from the database
		List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQuestions);
		
		//create a new object of quiz
		Quiz quiz = new Quiz();
		quiz.setQuizTitle(title);
		quiz.setQuestions(questions);
		
		quizRepository.save(quiz);
		
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
		try {
			
			Optional<Quiz> quiz = quizRepository.findById(id);
			
			List<Question> questionsFromDB = quiz.get().getQuestions();
			List<QuestionWrapper> questionsForUser = new ArrayList<>();

			//loop through each questions and create question wrappers with the required info
			for(Question q: questionsFromDB) {
				//create new Object for question wrapper
				QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
				questionsForUser.add(qw);
			}
					
			return new ResponseEntity<List<QuestionWrapper>>(questionsForUser, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<QuestionWrapper>>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		
		//get the quiz
		Quiz quiz = quizRepository.findById(id).get();
		
		//get the questions in the quiz
		List<Question> questions = quiz.getQuestions();
		
		int right_answers = 0;
		int i = 0;
		
		for(Response response: responses) {
		
			//match question ids
			if(response.getId().equals(questions.get(i).getId())) {
				if(response.getResponse().equals(questions.get(i).getCorrectAnswer())) {
					right_answers++;
				}				
			}
			i++;
		}
		
		return new ResponseEntity<Integer>(right_answers, HttpStatus.OK);
	}
	

}
