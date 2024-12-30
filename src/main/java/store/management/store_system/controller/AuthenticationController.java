package store.management.store_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.management.store_system.dto.AppResponse;
import store.management.store_system.dto.AuthenticationDto;
import store.management.store_system.dto.RegistrationDto;
import store.management.store_system.service.auth.AuthenticationService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("all")
    public String getAllStaffs(){
        return "hello";
    }

    @PostMapping("create_account")
    public ResponseEntity<AppResponse<String>> createAccount(@RequestBody @Valid RegistrationDto registrationDto){
        return ResponseEntity.ok(authenticationService.createAccount(registrationDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AppResponse<String>> login(@RequestBody AuthenticationDto authenticationDto){
        return ResponseEntity.ok(authenticationService.signIn(authenticationDto));
    }
}
