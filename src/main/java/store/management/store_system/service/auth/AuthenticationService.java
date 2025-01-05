package store.management.store_system.service.auth;

import store.management.store_system.dto.AppResponse;
import store.management.store_system.dto.AuthenticationDto;
import store.management.store_system.dto.RegistrationDto;
import store.management.store_system.dto.UpdateProfile;

public interface AuthenticationService {
    AppResponse<String> signIn(AuthenticationDto authenticationDto);

    AppResponse<String> createAccount(RegistrationDto registrationDto);

}
