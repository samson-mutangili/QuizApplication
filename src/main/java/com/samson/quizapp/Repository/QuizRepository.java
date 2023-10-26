package com.samson.quizapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.samson.quizapp.models.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Integer>{

}
