package fr.adaming.projet.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Employe;
import fr.adaming.projet.restaurant.repository.IEmployeRepository;

@Service
public class EmployeService implements IEmployeService {
	
	@Autowired
	IEmployeRepository employeRepository;

	@Override
	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> getAllEmploye() {
		return employeRepository.findAll();
	}

	@Override
	public Employe getOneEmploye(long id) {
		Optional<Employe> employeOptional = employeRepository.findById(id);
		Employe employe = new Employe();
		if (employeOptional.isPresent())
			employe = employeOptional.get();
		return employe;
	}

	@Override
	public Boolean deleteEmploye(long id) {
		try {
			employeRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	

}
