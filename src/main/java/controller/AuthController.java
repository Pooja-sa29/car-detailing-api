package controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        if (email == null || password == null ||
            email.trim().isEmpty() || password.isEmpty()) {

            return ResponseEntity.badRequest().body(
                Map.of(
                    "success", false,
                    "message", "Email and password are required"
                )
            );
        }

        // TODO: Validate credentials against PostgreSQL.
        // Do not compare or store plain-text passwords.

        return ResponseEntity.ok(
            Map.of(
                "success", true,
                "message", "Login API is working"
            )
        );
    }
}