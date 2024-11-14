package az.matrix.springmatrix161.controller;

import az.matrix.springmatrix161.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeClient employeeClient;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer id) {
        ResponseEntity<?> response = null;
        try {
            response = employeeClient.getEmployee(id);
            return response;
        } catch (CustomException e) {
            String message = e.getEmployee().getMessage();
            return ResponseEntity.ok(message);
        }
    }
}
