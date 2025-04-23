package bralis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bralis.model.Nalog;

public interface NalogRepository extends JpaRepository<Nalog, Long>{

	List<Nalog> findByCompanyId(Long companyId);
}