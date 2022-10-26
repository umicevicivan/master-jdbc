package com.master.masterhibernate.repositories;

import com.master.masterhibernate.domain.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer> {


    List<Avion> findAllByProizvodjac(String proizvodjac);


    List<Avion> findByProizvodjac(String proizvodjac);

    List<Avion> findAll();

    @Transactional
    @Query("select a from Avion a")
    List<Avion> findAllWithHQL();


    @Transactional
    @Modifying
    @Query("update Avion a set a.registracioniBroj = :regBroj where 1=1")
    void updateWithHQL(@Param("regBroj") int regBroj);
}
