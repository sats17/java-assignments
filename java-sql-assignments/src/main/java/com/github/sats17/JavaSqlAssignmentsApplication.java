package com.github.sats17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaSqlAssignmentsApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaSqlAssignmentsApplication.class, args);
    }

//    @Bean
//    public String ingestData() {
//        System.out.println("Ingesting data");
//        for(int i = 0; i < 10; i++) {
//            Account acc = new Account();
//            acc.setId(String.valueOf(i));
//            acc.setOwner(UUID.randomUUID().toString());
//            acc.setValue(1000);
//            accCrudRepo.save(acc).subscribe(entity -> System.out.println("Entity has been saved: {}"+ entity));
//        }
//        Account acc = new Account();
//        acc.setId(String.valueOf(55));
//        acc.setOwner(UUID.randomUUID().toString());
//        acc.setValue(5 + 1000);
//        accCrudRepo.save(acc).subscribe(entity -> System.out.println("Entity has been saved: {}"+ entity));
//        return null;
//    }

}