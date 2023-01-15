package com.example.bookstore.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "publishers", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode


public class PublisherEntity {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "publish_date")
    private String publishDate;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "book_type")
    private String bookType;

    @Column(name = "book_language")
    private String bookLanguage;

    public PublisherEntity(String publisherName, String publishDate, Integer pages, String bookType, String bookLanguage) {
        this.publisherName = publisherName;
        this.publishDate = publishDate;
        this.pages = pages;
        this.bookType = bookType;
        this.bookLanguage = bookLanguage;
    }
}