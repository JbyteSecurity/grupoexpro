package com.example.backend.service;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
        final User user =userRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception-Kaynak Bulunamadı"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());

    }
    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user=userRepository.save(new User(userCreateDTO.getRuc(),userCreateDTO.getRazonSocial(),userCreateDTO.getDireccion(), userCreateDTO.getEstado()));
        return UserViewDTO.of(user);
    }



}
