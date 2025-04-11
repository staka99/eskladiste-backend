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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kupac", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Kupac {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kupac_seq")
    @SequenceGenerator(name = "kupac_seq", allocationSize = 1)
    private Long id;

    @Column
    private String naziv;
    
    @Column
    private String adresa;
    
    @Column
    private String postanskiBroj;
    
    @Column
    private String grad;
    
    @OneToMany(mappedBy="kupac")
	@JsonIgnore
	private List<Nalog> nalozi;
    
	
}
