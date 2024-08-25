package com.cakes.Service;

import com.cakes.DTO.AuthenticationRequest;
import com.cakes.DTO.AuthenticationResponse;
import com.cakes.DTO.RegisterRequest;
import com.cakes.Model.Administrateur;
import com.cakes.Model.Role;
import com.cakes.Model.User;
import com.cakes.Repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonneRepository userdao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = new User();
        user.setUsername(request.getUsername());
        user.setAddresse(request.getAddresse());
        user.setTelephone(request.getTelephone());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        userdao.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())  // Include the role in the response
                .build();
    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var admin = new Administrateur();
        admin.setUsername(request.getUsername());
        admin.setEmail(request.getEmail());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setRole(Role.ADMIN);
        userdao.save(admin);

        var jwtToken = jwtService.generateToken(admin);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(admin.getRole().name())  // Include the role in the response
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userdao.findByusername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())  // Include the role in the response
                .build();
    }


}
