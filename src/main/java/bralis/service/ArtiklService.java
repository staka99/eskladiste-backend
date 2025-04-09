package bralis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bralis.model.Artikl;
import bralis.repository.ArtiklRepository;

@Service
public class ArtiklService {
	
	@Autowired
	private ArtiklRepository repository;
	
	
	public List<Artikl> getAll(){
		return repository.findAll();
	}
	
	public Optional<Artikl> findById(long id){
		return repository.findById(id);
	}
	
	
	public Artikl save(Artikl artikl) {
		return repository.save(artikl);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}