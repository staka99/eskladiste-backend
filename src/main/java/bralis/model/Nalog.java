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
@Table(name = "nalog", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nalog {
	

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nalog_seq")
    @SequenceGenerator(name = "nalog_seq", allocationSize = 1)
    private Long id;
	
    @Column
    private String broj;

    @Column
    private Date datum;

	@ManyToOne
	@JoinColumn(name="kupac")
	private Kupac kupac;

    @Column
    private boolean zavrsen;
    
    @OneToMany(mappedBy="nalog")
	@JsonIgnore
	private List<Stavka> stavke;
    
    @ManyToOne
	@JoinColumn(name="company")
    private Company company;

}
