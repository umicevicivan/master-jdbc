package com.master.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvioKompanija {
    private Integer id;
    private String naziv;
    private String ceo;
    private Integer brojDestinacija;
    private String pozivniZnak;
    private List<Avion> avioni;
}

