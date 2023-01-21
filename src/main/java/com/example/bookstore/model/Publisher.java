package com.example.bookstore.model;

import com.example.bookstore.entity.PublisherEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    private Long id;
    private String publisherName;
    private String publishDate;
    private Integer pages;
    private String bookType;
    private String bookLanguage;

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
