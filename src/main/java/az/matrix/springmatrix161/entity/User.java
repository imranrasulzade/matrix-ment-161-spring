package az.matrix.springmatrix161.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "users")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Boolean status;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Account account;

}