package tn.esprit.clientms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientMsApplication.class, args);
    }

}
