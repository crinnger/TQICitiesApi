package br.com.crinnger.cidadesapi.repository;

import br.com.crinnger.cidadesapi.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {
}
