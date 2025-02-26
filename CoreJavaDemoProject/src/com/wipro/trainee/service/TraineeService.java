package com.wipro.trainee.service;

import java.util.ArrayList;
import java.util.List;

import com.wipro.trainee.exception.TraineeNotFoundException;
import com.wipro.trainee.model.Trainee;

public class TraineeService {
	private List<Trainee> listOfTrainee;

	public TraineeService() {
		// empty list initialization
		this.listOfTrainee = new ArrayList<Trainee>();
	}

	public Trainee addTrainee(Trainee trainee) {
		listOfTrainee.add(trainee);
		return trainee;
	}

	public List<Trainee> findAllTrainee() {
		return listOfTrainee;
	}

	public Trainee getTraineeByID(int id) throws TraineeNotFoundException {
		for (Trainee trainee : listOfTrainee) {
			if (trainee.getTid() == id)
				return trainee;
		}
		throw new TraineeNotFoundException(id);
	}
	
	public List<Trainee> getTraineeStartingWith(String character) {
		return listOfTrainee.stream().filter(t->t.getTraineeName().startsWith(character)).toList();
	}

}
