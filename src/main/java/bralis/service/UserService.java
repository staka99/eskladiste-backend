package bralis.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import bralis.config.JwtService;
import bralis.model.User;
import bralis.repository.UserRepository;
import bralis.security.AuthenticationRequest;
import bralis.security.AuthenticationResponse;

@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	
	public List<User> getAll(){
		return repository.findAll();
	}
	
	public Optional<User> findById(long id){
		return repository.findById(id);
	}
	
	
	public User save(User user) {
		var dbUser = User.builder()
				.username(user.getUsername())
				//.company(user.getCompany())
				.password(passwordEncoder.encode(user.getPassword()))
				.role(user.getRole())
				.build();
		
		return repository.save(dbUser);
	}
	
	public boolean existsById(long id) {
		return findById(id).isPresent();
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
		 authenticationManager.authenticate(
			        new UsernamePasswordAuthenticationToken(
			        		authenticationRequest.getUsername(),
			        		authenticationRequest.getPassword()
			        )
			    );
		var user = repository.findUserByUsername(authenticationRequest.getUsername()).get();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

}