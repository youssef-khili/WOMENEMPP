package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Training;

public interface IQuizService {
	Quiz addQuiz(Quiz q);
	List<Quiz> retrieveAllQuizes();
	void deleteQuiz(Integer IdQuiz);
	Quiz updateQuiz(Quiz q);
	Quiz retrieveQuiz(Integer IdQuiz);
	void ajouterEtAffecterQuizAFormation(Quiz quiz, Integer idTraining);

}
