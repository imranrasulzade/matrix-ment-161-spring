package az.matrix.springmatrix161.client;

import az.matrix.springmatrix161.controller.CustomException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;


public class EmployeeErrorDecoder implements ErrorDecoder {
    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public Exception decode(String s, Response response) {

        try {
            Employee employee = mapper.readValue(response.body().asInputStream(), Employee.class);
            System.out.println(employee);
            return new CustomException(employee);
        } catch (Exception e) {
            System.out.println("An unexpected error occured");
        }
        return null;
    }
}
