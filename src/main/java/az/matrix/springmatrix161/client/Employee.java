package az.matrix.springmatrix161.client;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
    private Boolean status;
    private String message;
    private Boolean success;
}