package store.management.store_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.management.store_system.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);

}
