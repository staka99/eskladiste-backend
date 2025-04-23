package bralis.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import bralis.model.User;

@Service
public class JwtService {
	
	
	private static final String SECRET_KEY = "DVfZf3xMhFhRGV7hlAVHBRvZKsxQXyjz567gs907YHue+gbUrewa1KgJZfdQgJPn";
	
	public String extractUsername(String jwt) {
		return extractClaim(jwt, Claims::getSubject);
	}
	
	public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(jwt);
		return claimsResolver.apply(claims);
	}
	
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}
	
	public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
		
		User user = (User)userDetails;
		
		return Jwts.builder()
		.setClaims(extractClaims)
		.setSubject(user.getUsername())
		.claim("role", user.getAuthorities())
		.claim("companyId", user.getCompany().getId())
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
		.signWith(getSignInKey(), SignatureAlgorithm.HS256)
		.compact();
		
	}

	public boolean isTokenValid(String jwt, UserDetails userDetails) {
		final String username = extractUsername(jwt);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
		
	}
	
	private boolean isTokenExpired(String jwt) {
		return extractExpiration(jwt).before(new Date());
	}

	private Date extractExpiration(String jwt) {
		return extractClaim(jwt, Claims::getExpiration);
	}

	private Claims extractAllClaims(String jwt) {
		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(jwt).getBody();
		
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	

}