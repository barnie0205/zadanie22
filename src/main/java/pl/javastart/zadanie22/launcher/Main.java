package pl.javastart.zadanie22.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pl.javastart.zadanie22")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
