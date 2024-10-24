package az.matrix.springmatrix161.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ExceptionDTO {
    private String message;
    private HttpStatus status;
    private Integer code;
}
