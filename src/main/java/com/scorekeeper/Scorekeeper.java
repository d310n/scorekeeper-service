package com.scorekeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Scorekeeper
{
    private static final Logger logger = LoggerFactory.getLogger(Scorekeeper.class);

    public static void main(String[] args)
    {
        SpringApplication.run(Scorekeeper.class, args);
        logger.info("Score keeper works!");
    }
}