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

import bralis.model.Artikl;
import bralis.service.ArtiklService;

@RestController
@CrossOrigin
public class ArtiklController {
	
	@Autowired
	private ArtiklService service;
	
	@GetMapping("/artikl")
	public List<Artikl> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/artikl/{id}")
	public ResponseEntity<?> getById(@PathVariable long id){
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.findById(id).get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Requested resource does not exist");
		}
	}
	
	@PostMapping("artikl")
    public ResponseEntity<Artikl> add(@RequestBody Artikl artikl) {
        Artikl savedArtikl = service.save(artikl);
        URI location = URI.create("/artikl/" + savedArtikl.getId());
        return ResponseEntity.created(location).body(savedArtikl);
    }
	
	@PutMapping("/artikl/{id}")
	public ResponseEntity<?> update(@RequestBody Artikl artikl, @PathVariable long id){
		if(service.existsById(id)) {
			artikl.setId(id);
			Artikl savedArtikl = service.save(artikl);
			return ResponseEntity.ok(savedArtikl);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@DeleteMapping("/artikl/{id}")
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
