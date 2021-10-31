package br.com.crinnger.cidadesapi.controller;

import br.com.crinnger.cidadesapi.domain.City;
import br.com.crinnger.cidadesapi.domain.State;
import br.com.crinnger.cidadesapi.repository.CityRepository;
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
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping
    public Page<City> listCountries(Pageable page){
        return cityRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCountry(@PathVariable Long id){
        Optional<City> city = cityRepository.findById(id);
        return city.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
