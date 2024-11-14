package az.matrix.springmatrix161.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeClientConfig {

    @Bean
    public EmployeeErrorDecoder getEmployeeErrorDecoder() {
        return new EmployeeErrorDecoder();
    }

//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return new CustomErrorDecoder();
//    }
}
