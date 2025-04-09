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

import bralis.model.Kupac;
import bralis.service.KupacService;

@RestController
@CrossOrigin
public class KupacController {

	@Autowired
	private KupacService service;
	
	@GetMapping("/kupac")
	public List<Kupac> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/kupac/{id}")
	public ResponseEntity<?> getById(@PathVariable long id){
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.findById(id).get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Requested resource does not exist");
		}
	}
	
	@PostMapping("kupac")
    public ResponseEntity<Kupac> add(@RequestBody Kupac kupac) {
		Kupac savedKupac = service.save(kupac);
        URI location = URI.create("/kupac/" + savedKupac.getId());
        return ResponseEntity.created(location).body(savedKupac);
    }
	
	@PutMapping("/kupac/{id}")
	public ResponseEntity<?> update(@RequestBody Kupac kupac, @PathVariable long id){
		if(service.existsById(id)) {
			kupac.setId(id);
			Kupac savedKupac = service.save(kupac);
			return ResponseEntity.ok(savedKupac);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@DeleteMapping("/kupac/{id}")
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
