package store.management.store_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import store.management.store_system.dto.AppResponse;
import store.management.store_system.dto.RegistrationDto;
import store.management.store_system.entity.User;
import store.management.store_system.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    public AppResponse<String> createAccount(RegistrationDto registrationDto) {
        System.out.println(registrationDto.getFirstName() + "this is the email");
        boolean check = userRepository.existsByEmail(registrationDto.getEmail());

        if(check) return new AppResponse<>(0, "user already exist");

        User user = new User();

        user.setEmail(registrationDto.getEmail());
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());

        if(registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            user.setPassword(registrationDto.getPassword());
        }else{
            return new AppResponse<>(-1, "password does not correspond");
        }

        user.setRole("Admin");

        User savedUser = userRepository.save(user);


        return new AppResponse<>(0, savedUser.getLastName() + " your account has been created");
    }
}
