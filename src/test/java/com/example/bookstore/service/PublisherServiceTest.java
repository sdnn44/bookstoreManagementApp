package com.example.bookstore.service;

import com.example.bookstore.entity.PublisherEntity;
import com.example.bookstore.model.Publisher;
import com.example.bookstore.repository.PublisherRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PublisherServiceTest {
    @Mock
    PublisherRepository publisherRepository;

    @InjectMocks
    PublisherService publisherService;

    private final List<PublisherEntity> mockPublishers = List.of(
            new PublisherEntity("John Murray Publishers", "January 30, 2020", 345, "Paperback", "English"),
            new PublisherEntity("John Murray Publishers", "January 01, 2018", 200, "Paperback", "Polish")
    );

    @Test
    void shouldReturnAllStocks() {
        Mockito.when(publisherRepository.findAll()).thenReturn(mockPublishers);

        //when
        List<Publisher> result = publisherService.getAllPublishers();
        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).getPages()).isEqualTo(345);
        Assertions.assertThat(result.get(1).getPages()).isEqualTo(200);
    }

    @Test
    void shouldReturnPublisherByGivenPublisherId() {
        Mockito.when(publisherRepository.findById(1L)).thenReturn(Optional.ofNullable(mockPublishers.get(1)));

        //when
        Publisher result = publisherService.getPublisherById(1L).orElse(null);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getPages()).isEqualTo(200);
    }
}
