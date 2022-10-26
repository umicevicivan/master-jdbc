package com.master.masterhibernate.repositories;

import com.master.masterhibernate.domain.AvioKompanija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvioKompanijaRepository extends JpaRepository<AvioKompanija, Integer> {

    List<AvioKompanija> findAll();

}
