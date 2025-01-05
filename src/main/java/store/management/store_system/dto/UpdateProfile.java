package store.management.store_system.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class UpdateProfile {
    private Optional<String> lastName = Optional.empty();
    private Optional<String> firstName = Optional.empty();
}
