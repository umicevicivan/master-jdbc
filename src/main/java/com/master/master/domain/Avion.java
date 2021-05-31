package com.master.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avion {
    private Integer id;
    private Integer registracioniBroj;
    private String proizvodjac;
    private String model;
    private Integer brojSedista;
}
