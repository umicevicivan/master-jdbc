package com.master.masterhibernate.servicesImpl;

import com.master.masterhibernate.domain.Avion1;
import com.master.masterhibernate.repositories.Avion1Repository;
import com.master.masterhibernate.services.Avion1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class Avion1ServiceImpl implements Avion1Service {

    @Autowired
    private Avion1Repository avion1Repository;

    @Override
    public List<Avion1> findAllWithSpecification(int regBroj, String proizvodnjac, String model, int brojSedista) {
        Specification<Avion1> specification = Specification.where(null);
        if (regBroj != 0) {
            specification = specification.and((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("registracioni_broj"), regBroj));
        }
        if (StringUtils.hasLength(proizvodnjac)) {
            specification = specification.and((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("proizvodjac"), proizvodnjac));
        }
        if (StringUtils.hasLength(model)) {
            specification = specification.and((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("model"), model));
        }
        if (brojSedista != 0) {
            specification = specification.and((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("broj_sedista"), brojSedista));
        }
        return avion1Repository.findAll(specification);
    }

    @Override
    public List<Avion1> findAll() {
        return avion1Repository.findAll();
    }

    @Override
    public void deleteAll() {
        avion1Repository.deleteAll();
    }

    @Override
    public void insertAll(List<Avion1> lista) {
        avion1Repository.saveAll(lista);
    }

    @Override
    public void updateWithHQL() {
        avion1Repository.updateWithHQL();
    }

    @Override
    public List<Avion1> updateNoHQL() {
        List<Avion1> allResults = avion1Repository.findAll();
        allResults.forEach(result -> result.setRegistracioniBroj(60));
        return avion1Repository.saveAll(allResults);
    }

    @Override
    public List<Avion1> findAllWithHQL() {
        return avion1Repository.findAllWithHQL();
    }

    // ovde napravi jednu opstu update metodu koja prima objekat, da bi imao da kopiras kod i da objasnis
    // da je ovo glupo
    @Override
    public Avion1 updateModel(String oldModel, String newModel) {
        Avion1 avion = avion1Repository.findByModel(oldModel);
        avion.setModel(newModel);
        return avion1Repository.save(avion);
    }

    @Override
    public void updateModelWithHQL(String oldModel, String newModel) {
        avion1Repository.updateModelWithHQL(oldModel, newModel);
    }

    @Override
    public List<Avion1> createList() {
        List<Avion1> lista = new ArrayList<>();
        String[] proizvodjac = {"Boeing", "Airbus", "Lockheed Martin", "Northrop Grumman", "Safran",
                "Rolls-Royce Holdings", "Bombardier"};
        for (int i = 1; i <= 100; i++) {
            Avion1 a = new Avion1();
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
