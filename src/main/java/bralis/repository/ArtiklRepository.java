package bralis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bralis.model.Artikl;

public interface ArtiklRepository extends JpaRepository<Artikl, Long>{

	List<Artikl> findBySifra(String sifra);
	List<Artikl> findByCompanyId(Long companyId);
}