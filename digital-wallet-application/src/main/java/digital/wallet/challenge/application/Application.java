package digital.wallet.challenge.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "digital.wallet.challenge")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
