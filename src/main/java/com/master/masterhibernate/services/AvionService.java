package com.master.masterhibernate.services;

import com.master.masterhibernate.domain.Avion;

import java.util.List;

public interface AvionService {

    List<Avion> findAll();

    List<Avion> findAllWithHQL();

    List<Avion> findByProizvodjac(String proizvodjac);

    List<Avion> findAllBoeings();

    List<Avion> createList(int size);

    void updateNoHQL(int regBroj);

    void updateWithHQL(int regBroj);

    void deleteAll();

    void saveAll(List<Avion> list);

}
