package br.com.crinnger.cidadesapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Country {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portuguesName;

    @Column(name = "sigla")
    private String code;

    private int bacen;
}
