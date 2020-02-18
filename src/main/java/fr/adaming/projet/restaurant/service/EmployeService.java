package fr.adaming.projet.restaurant.service;

import java.security.Key;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.adaming.projet.restaurant.model.Employe;
import fr.adaming.projet.restaurant.repository.IEmployeRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class EmployeService implements IEmployeService {
	
	@Autowired
	IEmployeRepository employeRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	@Override
	public Employe saveEmploye(Employe employe) {
		employe.setMdp(bCryptPasswordEncoder.encode(employe.getMdp()));
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
