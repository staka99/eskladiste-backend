package bralis.model;

import java.util.Date;
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
@Table(name = "transakcija", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transakcija {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transakcija_seq")
    @SequenceGenerator(name = "transakcija_seq", allocationSize = 1)
    private Long id;

    @Column
    private Date datum;
    
    @Column
    private double kolicina;
    

    @Column
    private String opis;
    
	@ManyToOne
	@JoinColumn(name="artikl")
	private Artikl artikl;
	
	/*@ManyToOne
	@JoinColumn(name="kupac")
	private Kupac kupac;*/
	
}
