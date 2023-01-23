package com.example.bookstore.controller;

import com.example.bookstore.entity.RoleEntity;
import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.model.Publisher;
import com.example.bookstore.service.PublisherService;
import com.example.bookstore.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = {UserRestController.class})
public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    private JacksonTester<List<UserEntity>> jacksonReview;

    @Test
    void shouldReturnAllPublishers() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(List.of(
                new UserEntity("user", "$2a$10$nkzrCXmW3wi1o6SS/V9mG.OJcD9IqImGZNXXvSjnP.ksDHEUc3V0i", new RoleEntity())
        ));
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/users").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(
                jacksonReview.write(List.of(
                        new UserEntity("user", "$2a$10$nkzrCXmW3wi1o6SS/V9mG.OJcD9IqImGZNXXvSjnP.ksDHEUc3V0i", new RoleEntity())
                )).getJson()
        );
    }
}
