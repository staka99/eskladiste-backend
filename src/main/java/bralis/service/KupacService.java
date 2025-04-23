package bralis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bralis.model.Artikl;
import bralis.model.Kupac;
import bralis.repository.KupacRepository;

@Service
public class KupacService {

	@Autowired
	private KupacRepository repository;
	
	public List<Kupac> getAll(){
		return repository.findAll();
	}
	
	public Optional<Kupac> findById(long id){
		return repository.findById(id);
	}	
	
	public Kupac save(Kupac kupac) {
		return repository.save(kupac);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	public List<Kupac> getKupciByCompany(Long companyId) {
        return repository.findByCompanyId(companyId);
    }
	
}
