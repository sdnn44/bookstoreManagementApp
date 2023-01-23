//package com.example.bookstore.controller;
//import com.example.bookstore.model.Book;
//import com.example.bookstore.model.Publisher;
//import com.example.bookstore.model.Review;
//import com.example.bookstore.model.Stock;
//import com.example.bookstore.service.BookService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//@AutoConfigureJsonTesters
//@AutoConfigureMockMvc(addFilters = false)
//@WebMvcTest(controllers = {BookRestController.class})
//public class BookRestControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    BookService bookService;
//
//    @Autowired
//    private JacksonTester<List<Book>> jacksonBook;
//
//    @Test
//    void shouldReturnAllBooks() throws Exception {
////        Mockito.when(bookService.getAllBooks()).thenReturn(List.of(
////                new Book(1L, new Stock(1L, 12, true), new Publisher(1L, "publisherName", "publishDate", 111, "bookType", "bookLanguage"), "title", "author", new BigDecimal("15.00"), "category", "ISBN", "descr", List.of(new Review(1L, 1L, 3, "Not a big fan", "jonas@gmail.com", "jonte")))
////        ));
//        MockHttpServletResponse response = mockMvc.perform(
//                get("/books").accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//
//        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
////        Assertions.assertThat(response.getContentAsString()).isEqualTo(
////                jacksonBook.write(List.of(
////                        new Book(1L, new Stock(1L, 12, true), new Publisher(1L, "publisherName", "publishDate", 111, "bookType", "bookLanguage"), "title", "author", new BigDecimal("15.00"), "category", "ISBN", "descr", List.of(new Review(1L, 1L, 3, "Not a big fan", "jonas@gmail.com", "jonte")))
////                )).getJson()
////        );
//    }
//}
