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

import bralis.model.Company;
import bralis.service.CompanyService;

@RestController
@CrossOrigin
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@GetMapping("/company")
	public List<Company> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<?> getAById(@PathVariable long id){
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.findById(id).get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Requested resource does not exist");
		}
	}
	
	@PostMapping("company")
    public ResponseEntity<Company> add(@RequestBody Company company) {
        Company savedCompany = service.save(company);
        URI location = URI.create("/company/" + savedCompany.getId());
        return ResponseEntity.created(location).body(savedCompany);
    }
	
	@PutMapping("/company/{id}")
	public ResponseEntity<?> update(@RequestBody Company company, @PathVariable long id){
		if(service.existsById(id)) {
			company.setId(id);
			Company savedCompany = service.save(company);
			return ResponseEntity.ok(savedCompany);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	@DeleteMapping("/company/{id}")
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
