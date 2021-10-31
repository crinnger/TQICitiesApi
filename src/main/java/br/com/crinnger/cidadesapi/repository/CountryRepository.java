package br.com.crinnger.cidadesapi.repository;

import br.com.crinnger.cidadesapi.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
