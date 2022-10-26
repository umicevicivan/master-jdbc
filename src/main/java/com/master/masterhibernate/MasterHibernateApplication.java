package com.master.masterhibernate;

import com.master.masterhibernate.services.AerodromService;
import com.master.masterhibernate.services.AvioKompanijaService;
import com.master.masterhibernate.services.Avion1Service;
import com.master.masterhibernate.services.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class MasterHibernateApplication implements CommandLineRunner {

    @Autowired
    Avion1Service avion1Service;
    @Autowired
    AvionService avionService;
    @Autowired
    AvioKompanijaService avioKompanijaService;
    @Autowired
    AerodromService aerodromService;

    public static void main(String[] args) {
        SpringApplication.run(MasterHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Start");

        Instant timeStart = Instant.now();

        // method that is observed
//        List<Avion> avioni = avionService.findByProizvodjac("Boeing");

        Instant timeStop = Instant.now();
        Duration interval = Duration.between(timeStart, timeStop);

        System.out.println("======");
        System.out.println("Interval: " + interval.toMillis());
        System.out.println("======");
    }
}
