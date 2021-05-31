package com.master.master;

import com.master.master.domain.AvioKompanija;
import com.master.master.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class MasterApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MasterApplication.class, args);
        AvionDao avionDao = (AvionDao) context.getBean("avionDao");
        AvioKompanijaDao avioKompanijaDao = (AvioKompanijaDao) context.getBean("avioKompanijaDao");
        DrzavaDao drzavaDao = (DrzavaDao) context.getBean("drzavaDao");
        AerodromDao aerodromDao = (AerodromDao) context.getBean("aerodromDao");
        OsobaDao osobaDao = (OsobaDao) context.getBean("osobaDao");
        LetDao letDao = (LetDao) context.getBean("letDao");
        PosedujeDao posedujeDao = (PosedujeDao) context.getBean("posedujeDao");
        System.out.println("Pozic vozic");

        Instant timeStart = Instant.now();
//        avionDao.insertAll();
//        avionDao.deleteAll();
//        List<Avion> avioni = avionDao.findAll();
//        List<Avion> avioni = avionDao.findBoeing();


//        avioKompanijaDao.insertAll();
        List<AvioKompanija> avioKompanije = avioKompanijaDao.findAll();
//        avioKompanijaDao.update("test", "ceo: 31");

//        drzavaDao.insertAll();
//        List<Drzava> drzave = drzavaDao.findAll();

//        aerodromDao.insertAll();
//        List<Aerodrom> aerodromi = aerodromDao.findAll();
//        List<Aerodrom> aerodromi = aerodromDao.searchCountry("Canada");
//        aerodromDao.updateName(":Ecudaor", "Ecudaor");

//        osobaDao.insertAll();

//        letDao.insert();

//        posedujeDao.insertAll();
//        List<Poseduje> poseduje =  posedujeDao.findAll();

        Instant timeStop = Instant.now();
        Duration interval = Duration.between(timeStart, timeStop);
        System.out.println(avioKompanije.get(0).getAvioni().size());
        System.out.println(avioKompanije.size());
        System.out.println("Time passed: " + interval.toMillis());
    }


}
