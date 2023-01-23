package com.example.bookstore.controller;

import com.example.bookstore.model.Publisher;
import com.example.bookstore.model.Review;
import com.example.bookstore.service.ReviewService;
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
@WebMvcTest(controllers = {ReviewRestController.class})
class ReviewRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ReviewService reviewService;
    @Autowired
    private JacksonTester<List<Review>> jacksonReview;

    @Test
    void shouldReturnAllReviews() throws Exception {
        Mockito.when(reviewService.getAllReviews()).thenReturn(List.of(
                new Review(1L, 1L, 4, "Content", "email", "login")
        ));
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/reviews").accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(
                jacksonReview.write(List.of(
                        new Review(1L, 1L, 4, "Content", "email", "login")
                )).getJson()
        );
    }
}
