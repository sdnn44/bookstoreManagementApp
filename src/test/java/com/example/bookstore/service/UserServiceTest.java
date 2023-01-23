package com.example.bookstore.service;

import com.example.bookstore.entity.RoleEntity;
import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.model.ERole;
import com.example.bookstore.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.example.bookstore.model.ERole.ADMIN;
import static com.example.bookstore.model.ERole.USER;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    private final List<UserEntity> mockUsers = List.of(
            new UserEntity("user", "$2a$10$nkzrCXmW3wi1o6SS/V9mG.OJcD9IqImGZNXXvSjnP.ksDHEUc3V0i", new RoleEntity()),
            new UserEntity("admin", "$2a$10$nkzrCXmW3wi1o6SS/V9mG.OJcD9IqImGZNXXvSjnP.ksDHEUc3V0i", new RoleEntity())
    );

    @Test
    void shouldReturnAllUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

        //when
        List<UserEntity> result = userService.getAllUsers();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
    @Test
    void shouldReturnUserByUsername() {
        Mockito.when(userRepository.findByUsername("user")).thenReturn(Optional.ofNullable(mockUsers.get(0)));

        //when
        UserEntity result = userService.getUserByUsername("user").orElse(null);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getUsername()).isEqualTo("user");
    }
}
