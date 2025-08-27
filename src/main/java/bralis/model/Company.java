package bralis.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import bralis.model.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq", allocationSize = 1)
    private Long id;
	
	@Column
    private String name;
	
    @OneToMany(mappedBy="company")
	@JsonIgnore
	private List<User> users;
    
    @OneToMany(mappedBy="company")
	@JsonIgnore
	private List<Transakcija> transakcije;
    
    @OneToMany(mappedBy="company")
	@JsonIgnore
	private List<Nalog> nalozi;
	
    @OneToMany(mappedBy="company")
	@JsonIgnore
	private List<Kupac> kupci;
    
    @OneToMany(mappedBy="company")
	@JsonIgnore
	private List<Artikl> artikli;
    
    @OneToMany(mappedBy="company")
	@JsonIgnore
	private List<Stanje> stanja;

}