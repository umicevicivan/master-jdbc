package com.master.masterhibernate.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "AVION", schema = "IVAN")
public class Avion implements Serializable {
    @Id
    private int id;
    private int registracioniBroj;
    private String proizvodjac;
    private String model;
    private int brojSedista;

    @ManyToMany(mappedBy = "avioni",
            fetch = FetchType.EAGER)
    @Transient
    private Set<AvioKompanija> avioKompanije = new HashSet<>();
}


