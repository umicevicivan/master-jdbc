package com.master.masterhibernate.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "AERODROM", schema = "IVAN")
public class Aerodrom implements Serializable {
    @Id
    private int id;
    private String naziv;
    private int brojPista;
    private int brojPrilaza;
    private int kapacitetAviona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DRZAVE", referencedColumnName = "ID")
    private Drzava drzava;
}


