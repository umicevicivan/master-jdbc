package com.master.masterhibernate.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode()
@Entity
@NoArgsConstructor
@Table(name = "DRZAVA", schema = "IVAN")
public class Drzava implements Serializable {
    @Id
    private Integer id;
    private String naziv;
    private String skraceniNaziv;
    private Integer brojStanovnika;

    @OneToMany(mappedBy = "drzava")
    @Transient
    private List<Aerodrom> aerodromi;
}


