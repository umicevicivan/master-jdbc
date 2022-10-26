package com.master.masterhibernate.servicesImpl;

import com.master.masterhibernate.domain.Avion;
import com.master.masterhibernate.repositories.AvionRepository;
import com.master.masterhibernate.services.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Override
    public List<Avion> findAll() {
        return avionRepository.findAll();
    }

    @Override
    public List<Avion> findAllWithHQL() {
        return avionRepository.findAllWithHQL();
    }

    @Override
    public List<Avion> findByProizvodjac(String proizvodjac) {
        return avionRepository.findAllByProizvodjac(proizvodjac);
    }

    @Override
    public void deleteAll() {
        avionRepository.deleteAll();
    }

    @Override
    public void saveAll(List<Avion> list) {
        avionRepository.saveAll(list);
    }

    @Override
    public void updateNoHQL(int regBroj) {
        List<Avion> allResults = avionRepository.findAll();
        allResults.forEach(result -> result.setRegistracioniBroj(regBroj));
        avionRepository.saveAll(allResults);
    }

    @Override
    public void updateWithHQL(int regBroj) {
        avionRepository.updateWithHQL(regBroj);
    }

    @Override
    public List<Avion> findAllBoeings() {
        return avionRepository.findByProizvodjac("Boeing");
    }


    @Override
    public List<Avion> createList(int size) {
        List<Avion> lista = new ArrayList<>();
        String[] proizvodjac = {"Boeing", "Airbus", "Lockheed Martin", "Northrop Grumman", "Safran",
                "Rolls-Royce Holdings", "Bombardier"};
        for (int i = 1; i <= 100; i++) {
            Avion a = new Avion();
            a.setId(i);
            a.setRegistracioniBroj((int) ((Math.random() * (999999 - 100000) + 100000)));
            a.setProizvodjac(proizvodjac[(int) ((Math.random() * (7) + 0))]);
            a.setModel("MOD:" + a.getRegistracioniBroj());
            a.setBrojSedista((int) ((Math.random() * (500 - 50) + 50)));
            lista.add(a);
        }
        return lista;
    }
}
