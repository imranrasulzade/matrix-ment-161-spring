package az.matrix.springmatrix161.dto;

import lombok.Data;

@Data
public class PageDTO <T>{
    T data;
    int size;
    int total;
}
