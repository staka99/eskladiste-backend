package bralis.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "stavka", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stavka {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stavka_seq")
    @SequenceGenerator(name = "stavka_seq", allocationSize = 1)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name="nalog")
	private Nalog nalog;
	
    @Column
    private String artikl;
    
    @Column
    private String sifra;

    @Column
    private double kolicina;
    
    @Column
    private String jedinica;
    
    @Column
    private double cijena;
    
}
