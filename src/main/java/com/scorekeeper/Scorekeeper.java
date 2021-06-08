package com.scorekeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Scorekeeper
{
    public static void main(String[] args)
    {
        SpringApplication.run(Scorekeeper.class, args);
        System.out.println("Score keeper works!");
    }
}