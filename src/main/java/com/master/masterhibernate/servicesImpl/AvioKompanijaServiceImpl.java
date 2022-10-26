package com.master.masterhibernate.servicesImpl;

import com.master.masterhibernate.domain.AvioKompanija;
import com.master.masterhibernate.repositories.AvioKompanijaRepository;
import com.master.masterhibernate.services.AvioKompanijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvioKompanijaServiceImpl implements AvioKompanijaService {

    @Autowired
    private AvioKompanijaRepository avioKompanijaRepository;


    @Override
    public List<AvioKompanija> findAll() {
        return avioKompanijaRepository.findAll();
    }
}
