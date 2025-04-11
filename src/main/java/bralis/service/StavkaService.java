package bralis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bralis.model.Stavka;
import bralis.repository.StavkaRepository;

@Service
public class StavkaService {

	@Autowired
	private StavkaRepository repository;
	
	public List<Stavka> getAll(){
		return repository.findAll();
	}
	
	public Optional<Stavka> findById(long id){
		return repository.findById(id);
	}	
	
	public Stavka save(Stavka stavka) {
		return repository.save(stavka);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public List<Stavka> getStavkeByNalog(Long nalogId) {
        return repository.findByNalogId(nalogId);
    }
	
	
}