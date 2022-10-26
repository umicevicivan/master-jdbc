package com.master.masterhibernate.services;

import com.master.masterhibernate.domain.Aerodrom;

import java.util.List;

public interface AerodromService {

    List<Aerodrom> findAll();

    List<Aerodrom> findAllByNazivDrzave(String naziv);

    List<Aerodrom> updateByNazivDrzave(String sufiks, String nazivDrzave);
}
