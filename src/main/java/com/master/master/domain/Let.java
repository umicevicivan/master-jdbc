package com.master.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Let {
    private Integer id;
    private String pozivniZnak;
    private Timestamp datunPoletanja;
    private String imePilota;
    private Avion avion;
    private Aerodrom aerodromOd;
    private Aerodrom aerodromDo;
}
