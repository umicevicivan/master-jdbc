package com.master.masterhibernate.repositories;

import com.master.masterhibernate.domain.Avion1;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Avion1Repository extends JpaRepository<Avion1, Integer> {

    List<Avion1> findAll(Specification<Avion1> specification);

    List<Avion1> findAll();

    List<Avion1> findByProizvodjac(String proizvodjac);

    Avion1 findByModel(String model);

    @Transactional
    @Query("select a from Avion1 a")
    List<Avion1> findAllWithHQL();

    @Transactional
    @Modifying
    @Query("update Avion1 a set a.registracioniBroj = 35 where 1=1")
    void updateWithHQL();

    @Transactional
    @Modifying
    @Query("update Avion1 a set a.model = ?2 where a.model = ?1")
    void updateModelWithHQL(String oldModel, String newModel);
}
