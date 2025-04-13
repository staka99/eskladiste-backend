package bralis.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bralis.model.Artikl;
import bralis.model.Stavka;
import bralis.repository.StavkaRepository;
import bralis.service.StavkaService;

@RestController
@CrossOrigin
public class StavkaController {

	@Autowired
	private StavkaService service;
	
	@GetMapping("/stavka")
	public List<Stavka> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/stavka/{id}")
	public ResponseEntity<?> getById(@PathVariable long id){
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.findById(id).get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Requested resource does not exist");
		}
	}
	
	@GetMapping("stavka/sifra/{sifra}")
	public ResponseEntity<List<Stavka>> getBySifra(@PathVariable("sifra") String sifra){
		List<Stavka> stavke = service.findBySifra(sifra);
        return new ResponseEntity<>(stavke, HttpStatus.OK);
	}
	
	@PostMapping("stavka")
    public ResponseEntity<Stavka> add(@RequestBody Stavka stavka) {
		Stavka savedStavka = service.save(stavka);
        URI location = URI.create("/stavka/" + savedStavka.getId());
        return ResponseEntity.created(location).body(savedStavka);
    }
	
	@PutMapping("/stavka/{id}")
	public ResponseEntity<?> update(@RequestBody Stavka stavka, @PathVariable long id){
		if(service.existsById(id)) {
			stavka.setId(id);
			Stavka savedStavka = service.save(stavka);
			return ResponseEntity.ok(savedStavka);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@DeleteMapping("/stavka/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Resource with requested ID: " + id + " has been deleted");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@GetMapping("/stavkeZaNalog/{id}")
	  public ResponseEntity<List<Stavka>> getStavkeByNalog(@PathVariable Long id) {
	      List<Stavka> stavke = service.getStavkeByNalog(id);
	      if (stavke.isEmpty()) {
	          return ResponseEntity.noContent().build();
	      }
	      return ResponseEntity.ok(stavke);
	  }
}
