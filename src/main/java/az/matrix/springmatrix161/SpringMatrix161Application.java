package az.matrix.springmatrix161;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringMatrix161Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMatrix161Application.class, args);
    }

}
