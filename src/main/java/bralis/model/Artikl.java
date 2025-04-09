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
@Table(name = "artikl", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Artikl {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artikl_seq")
    @SequenceGenerator(name = "artikl_seq", allocationSize = 1)
    private Long id;

    @Column
    private String sifra;
    
    @Column
    private String naziv;

    @Column
    private String jedinica;
    
    @Column
    private double stanje;
    
    @OneToMany(mappedBy="artikl")
	@JsonIgnore
	private List<Transakcija> transakcije;
	
}
