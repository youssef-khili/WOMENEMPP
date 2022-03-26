package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.TrainingRepository;

public interface ITrainingService  {
	Training addTraining(Training t);
	List<Training> retrieveAllTrainings();
	void deleteTraining(Integer IdTraining);
	Training updateTrainning(Training t);
	Training retrieveTraining(Integer IdTraining);
	void affecterApprenantFormation(Integer idUser,Integer IdTraining);
	Integer getRevenueByFormation(Integer idTraining);

}
