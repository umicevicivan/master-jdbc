package com.master.masterhibernate.repositories;

import com.master.masterhibernate.domain.Aerodrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AerodromRepository extends JpaRepository<Aerodrom, Integer> {

    List<Aerodrom> findAllByDrzava_Naziv(String naziv);


    List<Aerodrom> findAll();

}
