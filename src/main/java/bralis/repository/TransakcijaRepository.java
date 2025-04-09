package bralis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bralis.model.Transakcija;

public interface TransakcijaRepository extends JpaRepository<Transakcija, Long>{

}