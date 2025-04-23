package bralis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bralis.model.Artikl;
import bralis.model.Transakcija;

public interface TransakcijaRepository extends JpaRepository<Transakcija, Long>{

	List<Transakcija> findByCompanyId(Long companyId);
}