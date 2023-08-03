package com.neueda.boot.SpringBootDemo.exercise2;

import com.neueda.boot.SpringBootDemo.exercise2.entity.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

//    @Bean
//    Transaction transaction1()
//    {
//        return new Transaction(1, "C01","withdraw", LocalDate.of(2023, 06, 10));
//    }
//    @Bean
//    Transaction transaction2()
//    {
//       return new Transaction(3, "C01","deposit", LocalDate.of(2023, 06, 10));
//    }
//    @Bean
//    Transaction transaction3()
//    {
//       return new Transaction(2, "C02","withdraw", LocalDate.of(2023, 06, 10));
//    }

    @Bean
    List<Transaction> getAllTransactions()
    {
        System.out.println("bean");
        return Arrays.asList(new Transaction(1, "C01","withdraw", LocalDate.of(2023, 06, 10)),
                new Transaction(2, "C02","withdraw", LocalDate.of(2023, 06, 10)),
        new Transaction(3, "C01","deposit", LocalDate.of(2023, 06, 10)),
        new Transaction(4, "C03","withdraw", LocalDate.of(2023, 06, 10)),
                new Transaction(5, "C01","deposit", LocalDate.of(2023, 06, 10))
                );
    }
}
