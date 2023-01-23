package com.example.bookstore.controller;


import com.example.bookstore.model.Publisher;
import com.example.bookstore.service.PublisherService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = {PublisherRestController.class})
class PublisherRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PublisherService publisherService;

    @Autowired
    private JacksonTester<List<Publisher>> jacksonPublisher;

    @Test
    void shouldReturnAllPublishers() throws Exception {
        Mockito.when(publisherService.getAllPublishers()).thenReturn(List.of(
                new Publisher(1L, "Pub1", "Pub1", 200, "Pub1", "Pub1")
                ));
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/publishers").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(
                jacksonPublisher.write(List.of(
                        new Publisher(1L, "Pub1", "Pub1", 200, "Pub1", "Pub1")
                )).getJson()
        );
    }
}
