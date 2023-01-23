package com.example.bookstore.entity;

import com.example.bookstore.model.Publisher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PublisherEntityTest {
    @Test
    void shouldReturnPublisherEntityByGivenPublisher() {
        //given
        Publisher publisher = new Publisher(1L, "publisherName", "publishDate", 111, "bookType", "bookLanguage");
        //when
        PublisherEntity publisherEntity = PublisherEntity.fromPublisher(publisher);
        //then
//        Assertions.assertThat(stockEntity.getId()).isEqualTo(stock.getId());
        Assertions.assertThat(publisherEntity.getPublisherName()).isEqualTo(publisher.getPublisherName());
        Assertions.assertThat(publisherEntity.getPublishDate()).isEqualTo(publisher.getPublishDate());
        Assertions.assertThat(publisherEntity.getPages()).isEqualTo(publisher.getPages());
        Assertions.assertThat(publisherEntity.getBookType()).isEqualTo(publisher.getBookType());
        Assertions.assertThat(publisherEntity.getBookLanguage()).isEqualTo(publisher.getBookLanguage());
    }
}
