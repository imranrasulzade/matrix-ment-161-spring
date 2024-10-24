package az.matrix.springmatrix161.dto;


import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String name;
    private String surname;

    private String email;
    private Boolean status;
//    private AccountDto account;

}
