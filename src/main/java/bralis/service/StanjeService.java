package bralis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bralis.model.Kupac;
import bralis.model.Stanje;
import bralis.repository.StanjeRepository;

@Service
public class StanjeService {

	@Autowired
	private StanjeRepository repository;
	
	public List<Stanje> getAll(){
		return repository.findAll();
	}
	
	public Optional<Stanje> findById(long id){
		return repository.findById(id);
	}	
	
	public Stanje save(Stanje stanje) {
		return repository.save(stanje);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public List<Stanje> getStanjaByCompany(Long companyId) {
        return repository.findByCompanyId(companyId);
    }
	
}