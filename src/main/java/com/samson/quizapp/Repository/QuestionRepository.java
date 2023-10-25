package com.samson.quizapp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samson.quizapp.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);

}
