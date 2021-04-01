package com.mose.tetris;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class TetrisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TetrisApplication.class, args);
    }

}
