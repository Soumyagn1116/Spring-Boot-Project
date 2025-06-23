package com.app.fooddelivery.Controller;

import com.app.fooddelivery.Entity.User;
import com.app.fooddelivery.Model.JwtResponse;
import com.app.fooddelivery.Model.LoginRequest;
import com.app.fooddelivery.Security.JwtUtil;
import com.app.fooddelivery.Service.UserDetailsServiceImpl;
import com.app.fooddelivery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil; // ✅ Make sure your util class is named JwtUtil

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ Signup
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER"); // default role
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

@PostMapping("/login")
public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()
            )
    );

    UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
    String token = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new JwtResponse(token)); // ✅ this should be correct
}
}
