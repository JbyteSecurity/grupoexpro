package com.example.backend.service;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserViewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserViewDTO getUserById(Long id);

    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    List<UserViewDTO> getUsers();
}
