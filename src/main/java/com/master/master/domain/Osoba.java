package com.master.master.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Osoba {
    private Integer id;
    private String ime;
    private String prezime;
    private Integer godine;
    private String pol;
}

