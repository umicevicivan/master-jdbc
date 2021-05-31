package com.master.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aerodrom {
    private Integer id;
    private String naziv;
    private Integer brojPista;
    private Integer brojPrilaza;
    private Integer kapacitetAviona;
    private Drzava drzava;
}
