package com.master.masterhibernate.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode()
@NoArgsConstructor
@Entity
@Table(name = "AVIO_KOMPANIJA", schema = "IVAN")
public class AvioKompanija implements Serializable {
    @Id
    private Integer id;
    private String naziv;
    private String ceo;
    private Integer brojDestinacija;
    private String pozivniZnak;
    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "POSEDUJE",
            schema = "IVAN",
            joinColumns = {@JoinColumn(
                    name = "AVIO_KOMPANIJA_ID",
                    referencedColumnName = "ID"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "AVION_ID"
            )}
    )
    private List<Avion> avioni;
}
