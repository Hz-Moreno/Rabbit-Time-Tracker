package com.rabbit.application.controllers.auth;

import com.rabbit.application.dtos.ClientDTO;
import com.rabbit.application.models.Client;
import com.rabbit.application.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterController {
    private final ClientRepository clientRepository;

    @Autowired
    public RegisterController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ClientDTO clientDTO) {
        if (clientDTO == null ||
                clientDTO.getUsername() == null ||
                clientDTO.getPassword() == null ||
                clientDTO.getEmail() == null) {
            return ResponseEntity.badRequest().body("Client data is incomplete or invalid");
        }

        Client client = new Client();
        client.setUsername(clientDTO.getUsername());
        client.setPassword(clientDTO.getPassword());
        client.setEmail(clientDTO.getEmail());

        try {
            Client saved = clientRepository.save(client);
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro creating user: " + e.getMessage());
        }
    }
}