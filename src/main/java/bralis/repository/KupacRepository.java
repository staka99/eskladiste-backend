package bralis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bralis.model.Kupac;

public interface KupacRepository extends JpaRepository<Kupac, Long>{
	List<Kupac> findByCompanyId(Long companyId);

}