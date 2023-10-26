package com.samson.quizapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samson.quizapp.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQuestions);

}
