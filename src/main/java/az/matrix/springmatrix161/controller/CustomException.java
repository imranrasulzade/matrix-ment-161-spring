package az.matrix.springmatrix161.controller;

import az.matrix.springmatrix161.client.Employee;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private Employee employee;

    public CustomException(Employee employee) {
        this.employee = employee;
    }
}
