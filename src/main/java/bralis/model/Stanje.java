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
@Table(name = "stanje", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stanje {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stanje_seq")
    @SequenceGenerator(name = "stanje_seq", allocationSize = 1)
    private Long id;
	
    @Column
    private Date datum;
	
    @Column
    private double stanje;
    
    @ManyToOne
    @JoinColumn(name = "company") 
    private Company company;
	
}
