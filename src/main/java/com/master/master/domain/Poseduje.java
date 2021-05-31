package com.master.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poseduje {
    private Avion avion;
    private AvioKompanija avioKompanija;
    private Timestamp datumOd;
    private Timestamp datumDo;
}
