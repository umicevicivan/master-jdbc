package com.master.master;

import com.master.master.jdbc.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Duration;
import java.time.Instant;

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
        System.out.println("Start");


        Instant timeStart = Instant.now();

        // method observed

        Instant timeStop = Instant.now();
        Duration interval = Duration.between(timeStart, timeStop);

        System.out.println("======");
        System.out.println("Interval: " + interval.toMillis());
        System.out.println("======");

    }


}
