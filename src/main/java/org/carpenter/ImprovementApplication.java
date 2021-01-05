package org.carpenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ImprovementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImprovementApplication.class, args);
    }

}
