package br.com.crinnger.cidadesapi.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@TypeDefs({
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "uf" , referencedColumnName = "id")
    private State state;

    private int  ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false,insertable = false)
    private Point location;

    @Column(name = "lat_lon")
    private String geolocation;

    private Double latitude;

    private Double longitude;

    private int cod_tom;
}
