package com.example.aop.aspectjAdvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    private NewDocumentarist documentarist;

    @Autowired
    @Qualifier("documentarist")
    public void setDocumentarist(NewDocumentarist documentarist) {
        this.documentarist = documentarist;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        documentarist.execute();
    }
}
