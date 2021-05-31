package com.master.master;

import com.master.master.domain.AvioKompanija;
import com.master.master.domain.Avion;
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
        Avion1Dao avion1Dao = (Avion1Dao) context.getBean("avion1Dao");
        System.out.println("Pozic vozic");

        avion1Dao.createList();
        Instant timeStart = Instant.now();
//        avionDao.insertAll();
//        avionDao.deleteAll();
//        List<Avion> avioni = avionDao.findAll();
//        List<Avion> avioni = avionDao.findBoeing();


//        avioKompanijaDao.insertAll();
//        List<AvioKompanija> avioKompanije = avioKompanijaDao.findAll();
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
        System.out.println("Krenulo:");
//        avion1Dao.insertAll();
        avion1Dao.update();
        System.out.println("Gotovo");
//        List<Avion> avioni1 = avion1Dao.findAll();



        Instant timeStop = Instant.now();
        Duration interval = Duration.between(timeStart, timeStop);
//        System.out.println(avioni1.get(0));
//        System.out.println(avioni1.size());
        System.out.println("Time passed: " + interval.toMillis());
//        avion1Dao.deleteAll();
//        System.out.println("Deleted.");
    }


}
