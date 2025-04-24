package org.vitorfurini.kafkapoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vitorfurini.kafkapoc.request.LoginRequest;
import org.vitorfurini.kafkapoc.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if ("admin".equals(loginRequest.getUsername()) && "1234".equals(loginRequest.getPassword())) {
            String token = JwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
        } else {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }
}
