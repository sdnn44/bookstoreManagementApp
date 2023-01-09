package com.example.bookstore.model;

import com.example.bookstore.entity.PublisherEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class Publisher {
    private final int id;
    private final String publisherName;
    private final String publishDate;
    private final Integer pages;
    private final String bookType;
    private final String bookLanguage;

    public static Publisher fromEntity(PublisherEntity publisherEntity) {
        return new Publisher(
                publisherEntity.getId(),
                publisherEntity.getPublisherName(),
                publisherEntity.getPublishDate(),
                publisherEntity.getPages(),
                publisherEntity.getBookType(),
                publisherEntity.getBookLanguage());
    }
}
