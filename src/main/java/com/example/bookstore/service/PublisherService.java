package com.example.bookstore.service;

import com.example.bookstore.model.Publisher;
import com.example.bookstore.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.getAllPublishers();
    }

    public Optional<Publisher> getPublisherById(int id) {
        return publisherRepository.getPublisherById(id);
    }
}
