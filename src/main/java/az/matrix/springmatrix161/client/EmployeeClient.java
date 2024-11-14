package az.matrix.springmatrix161.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "employee-client", url = "${employee.client-url}"/*, configuration = EmployeeClientConfig.class*/)
public interface EmployeeClient {

    @GetMapping(EmployeeTemplate.GET_EMPLOYEE_BY_ID)
    ResponseEntity<?> getEmployee(@PathVariable("id") Integer id);
}
