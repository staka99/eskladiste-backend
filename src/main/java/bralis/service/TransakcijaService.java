package bralis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bralis.model.Transakcija;
import bralis.repository.TransakcijaRepository;

@Service
public class TransakcijaService {

	@Autowired
	private TransakcijaRepository repository;
	
	public List<Transakcija> getAll(){
		return repository.findAll();
	}
	
	public Optional<Transakcija> findById(long id){
		return repository.findById(id);
	}	
	
	public Transakcija save(Transakcija transakcija) {
		return repository.save(transakcija);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
}
