package com.master.masterhibernate.services;

import com.master.masterhibernate.domain.Avion1;

import java.util.List;

public interface Avion1Service {

    List<Avion1> findAllWithSpecification(int regBroj, String proizvodnjac, String model, int brojSedista);

    List<Avion1> findAll();

    List<Avion1> findAllWithHQL();

    List<Avion1> createList();

    void deleteAll();

    void insertAll(List<Avion1> list);

    void updateWithHQL();

    List<Avion1> updateNoHQL();

    Avion1 updateModel(String oldModel, String newModel);

    void updateModelWithHQL(String oldModel, String newModel);

}
