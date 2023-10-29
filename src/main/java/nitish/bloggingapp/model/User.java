package nitish.bloggingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nitish.bloggingapp.model.enums.AccountType;
import nitish.bloggingapp.model.enums.Gender;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userHandle;
    private String userBio;
    @Email
    private String userEmail;
    private String userPassword; //regex for strong password

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private boolean blueTick;

}
