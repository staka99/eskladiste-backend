package bralis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bralis.model.Stanje;

public interface StanjeRepository extends JpaRepository<Stanje, Long>{
	List<Stanje> findByCompanyId(Long companyId);

}
