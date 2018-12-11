package com.in28minutes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.service.SurveyService;
import com.in28minutes.springboot.model.Question;

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId){
		return surveyService.retrieveQuestions(surveyId);	
	}
	
	@GetMapping("/surveys/{surveyId}/questions")
	public Question retrieveDetailsForQuestionsForSurvey(@PathVariable String surveyId, @PathVariable String questionId){
		return surveyService.retrieveQuestion(surveyId, questionId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions/{questionId}")
	public ResponseEntity<Void> addQuestionsForSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion){
		Question question = surveyService.addQuestion(surveyId, newQuestion);
		
		if(question==null)
			return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
