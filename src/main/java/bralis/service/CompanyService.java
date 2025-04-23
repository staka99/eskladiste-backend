package bralis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bralis.model.Company;
import bralis.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository repository;
	
	
	public List<Company> getAll(){
		return repository.findAll();
	}
	
	public Optional<Company> findById(long id){
		return repository.findById(id);
	}
	
	
	public Company save(Company company) {
		return repository.save(company);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
