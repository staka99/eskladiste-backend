package bralis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bralis.model.Nalog;
import bralis.repository.NalogRepository;

@Service
public class NalogService {

	@Autowired
	private NalogRepository repository;
	
	public List<Nalog> getAll(){
		return repository.findAll();
	}
	
	public Optional<Nalog> findById(long id){
		return repository.findById(id);
	}	
	
	public Nalog save(Nalog nalog) {
		return repository.save(nalog);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	
}