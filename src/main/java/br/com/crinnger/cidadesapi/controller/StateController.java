package br.com.crinnger.cidadesapi.controller;

import br.com.crinnger.cidadesapi.domain.Country;
import br.com.crinnger.cidadesapi.domain.State;
import br.com.crinnger.cidadesapi.repository.CountryRepository;
import br.com.crinnger.cidadesapi.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateController {

    private final StateRepository stateRepository;

    @GetMapping
    public Page<State> listCountries(Pageable page){
        return stateRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getCountry(@PathVariable Long id){
        Optional<State> state = stateRepository.findById(id);
        return state.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
