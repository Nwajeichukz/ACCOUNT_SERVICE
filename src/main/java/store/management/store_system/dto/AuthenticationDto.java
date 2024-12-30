package store.management.store_system.dto;

import lombok.Data;

@Data
public class AuthenticationDto {
    private String email;

    private String password;
}
