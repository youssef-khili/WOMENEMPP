package tn.esprit.spring.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.repository.UserRepository;

@Slf4j
@Service("ITrainingService")
public class TrainingServiceImpl implements ITrainingService {
	
	@Autowired
	TrainingRepository trainingrepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailSenderService emailSenderService;

	
	
	public List<Training> retrieveAllTrainings(){	
		List<Training> trainings= (List<Training>) trainingrepository.findAll();  
		return trainings;
	}

	public Training addTraining(Training t){
		return trainingrepository.save(t);		
	}
	
	public void deleteTraining(Integer IdTraining){
		trainingrepository.deleteById(IdTraining);		
	}
	
	public Training updateTrainning(Training t){	
		return trainingrepository.save(t);
	}
	
	public Training retrieveTraining(Integer IdTraining){
		Training training=trainingrepository.findById(IdTraining).orElse(null);
		return training;
	}

	public void affecterApprenantFormation(Integer idUser,Integer IdTraining){
		User user=userRepository.findById(idUser).orElse(null);
		Training training=trainingrepository.findById(IdTraining).orElse(null);
		training.getUsers().add(user);
		trainingrepository.save(training);

	}

	@Scheduled(cron = "*/30 * * * * *")
	public void getNbrApprenantByFormation() {

		log.info("La formation : firsttraining contient : " + +userRepository.getNbrApprenantByFormation("firsttraining").size() + " Apprenant ");
		log.info("La formation : 2ndtraining contient : " + +userRepository.getNbrApprenantByFormation("2ndtraining").size() + " Apprenant ");
	}

	public Integer getRevenueByFormation(Integer idTraining) {
		Training t = trainingrepository.findById(idTraining).orElse(null);

		Integer revenue =  (t.getCost()*userRepository.getRevenueByFormation(idTraining).size());
		return  revenue;
	}

	@Scheduled(cron = "*/30 * * * * *")
	public void ListComplete()
	{
		for(Training t : trainingrepository.findAll())
		{
			if (userRepository.getNbrrApprenantByFormation(t.getTrainingName()) < t.getMaximumParticipantNumber())
			{
				this.emailSenderService.sendMail("youssef.kehili@esprit.tn", "Learner list no complete   ", " we have in this courses "+userRepository.getNbrApprenantByFormation(t.getTrainingName()).size() +" learner in this formation "+t.getTrainingName());
				log.info(" we have access to add this courses " + t.getMaximumParticipantNumber());
			}else {
				this.emailSenderService.sendMail("youssef.kehili@esprit.tn", "Learner list complete Max    ", " we have in this courses "+userRepository.getNbrApprenantByFormation(t.getTrainingName()).size() +" learner  in this formation "+t.getTrainingName());
				log.info(" Learner list complete Max learner " + t.getMaximumParticipantNumber());
			}
		}
	}
	

}
