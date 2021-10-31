package br.com.crinnger.cidadesapi.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String code;

    private int ibge;

    @ManyToOne
    @JoinColumn(name = "pais" , referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

}
