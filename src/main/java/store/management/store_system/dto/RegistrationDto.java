package store.management.store_system.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationDto {
    private String firstName;
    private String lastName;
    private String email;

    private String password;

    private String confirmPassword;

}
