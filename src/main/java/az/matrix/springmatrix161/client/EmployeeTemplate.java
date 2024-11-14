package az.matrix.springmatrix161.client;

public interface EmployeeTemplate {
    String GET_EMPLOYEE_BY_ID = "/getEmployeeById/{id}";
    String GET_EMPLOYEE_BY_NAME = "/getEmployeeByName/{name}";
    String GET_EMPLOYEE_BY_EMAIL = "/getEmployeeByEmail/{email}";
}
