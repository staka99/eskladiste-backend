package bralis.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bralis.model.Transakcija;
import bralis.service.TransakcijaService;

@RestController
@CrossOrigin
public class TransakcijaController {
	
	@Autowired
	private TransakcijaService service;
	
	@GetMapping("/transakcija")
	public List<Transakcija> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/transakcija/{id}")
	public ResponseEntity<?> getById(@PathVariable long id){
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.findById(id).get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Requested resource does not exist");
		}
	}
	
	@PostMapping("transakcija")
    public ResponseEntity<Transakcija> add(@RequestBody Transakcija transakcija) {
		Transakcija savedTransakcija = service.save(transakcija);
        URI location = URI.create("/transakcija/" + savedTransakcija.getId());
        return ResponseEntity.created(location).body(savedTransakcija);
    }
	
	@PutMapping("/transakcija/{id}")
	public ResponseEntity<?> update(@RequestBody Transakcija transakcija, @PathVariable long id){
		if(service.existsById(id)) {
			transakcija.setId(id);
			Transakcija savedTransakcija = service.save(transakcija);
			return ResponseEntity.ok(savedTransakcija);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@DeleteMapping("/transakcija/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Resource with requested ID: " + id + " has been deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Resource with requested ID: " + id + " has not been found");
		}
	}
}
