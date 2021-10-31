package br.com.crinnger.cidadesapi.controller;

import br.com.crinnger.cidadesapi.domain.Country;
import br.com.crinnger.cidadesapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping
    public Page<Country> listCountries(Pageable page){
        return countryRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Long id){
        Optional<Country> country = countryRepository.findById(id);
        return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
