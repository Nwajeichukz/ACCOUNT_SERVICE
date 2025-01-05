package store.management.store_system.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import store.management.store_system.service.MyUserDetailsService;
import store.management.store_system.service.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class BasicAuthConfig {

    private final MyUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


    public void handleBasicAuth(String authorizationHeader, HttpServletRequest request) {
        String base64Credentials = authorizationHeader.substring(6);
        System.out.println(base64Credentials + " THIS IS THE BASE 64 CODE");
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] userDetails = credentials.split(":", 2);


        if (userDetails.length == 2){
            String username = userDetails[0];
            String password = userDetails[1];
            UserDetails user = userDetailsService.loadUserByUsername(username);
            System.out.println(username + " " +  password + " USERNAME AND PASSWORD");

            System.out.println(user.getPassword() + " DB PASSWORD");

            if (passwordEncoder.matches(password,user.getPassword())) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
    }
}
