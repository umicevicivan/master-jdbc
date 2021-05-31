package com.master.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drzava {
    private Integer id;
    private String naziv;
    private String skraceniNaziv;
    private Integer brojStanovnika;
}
