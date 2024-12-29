package store.management.store_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import store.management.store_system.dto.AppResponse;
import store.management.store_system.dto.RegistrationDto;
import store.management.store_system.service.AuthenticationService;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("all")
    public String getAllStaffs(){
        return "hello";
    }

    @PostMapping("create_account")
    public ResponseEntity<AppResponse<String>> createAccount(@RequestBody RegistrationDto registrationDto){
        return ResponseEntity.ok(authenticationService.createAccount(registrationDto));
    }
}
