package store.management.store_system.dto;

import lombok.Data;
import store.management.store_system.entity.Role;
import store.management.store_system.entity.User;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;

    private String department;

    private String timeOfCreation;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.department = user.getDepartment();
        this.timeOfCreation = user.getTimeOfCreation();
    }
}
