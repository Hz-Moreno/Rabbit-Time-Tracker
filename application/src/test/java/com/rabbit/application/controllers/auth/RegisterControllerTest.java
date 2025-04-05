package com.rabbit.application.controllers.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.application.dtos.ClientDTO;
import com.rabbit.application.models.Client;
import com.rabbit.application.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RegisterControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClientRepository clientRepository;

    private RegisterController registerController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        registerController = new RegisterController(clientRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(registerController)
                .alwaysDo(print())
                .build();
    }

    @Test
    public void testRegisterSuccess() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setUsername("testuser");
        clientDTO.setPassword("password123");
        clientDTO.setEmail("test@example.com");

        when(clientRepository.save(any(Client.class))).thenReturn(new Client());

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().string("User successfully created"));

        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    public void testRegisterNullDTO() throws Exception {
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(clientRepository, never()).save(any(Client.class));
    }

    @Test
    public void testRegisterMissingFields() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setUsername("testuser");

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(status().isBadRequest());
        
        verify(clientRepository, never()).save(any(Client.class));
    }
}