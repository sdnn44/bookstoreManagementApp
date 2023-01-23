package com.example.bookstore.model;

import com.example.bookstore.entity.PublisherEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PublisherTest {
    @Test
    void shouldCreatePublisherByGivenPublisherEntity() {
        //given
        PublisherEntity publisherEntity = new PublisherEntity("Publisher Name", "Date", 115, "Book Type", "Book Language");
        //when
        Publisher publisher = Publisher.fromEntity(publisherEntity);
        //then
        Assertions.assertThat(publisher.getId()).isEqualTo(publisherEntity.getId());
        Assertions.assertThat(publisher.getPages()).isEqualTo(115);
        Assertions.assertThat(publisher.getBookType()).isEqualTo("Book Type");
    }
}
