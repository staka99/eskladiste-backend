package bralis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bralis.model.Stavka;

public interface StavkaRepository extends JpaRepository<Stavka, Long>{

	List<Stavka> findByNalogId(Long nalogId);
}