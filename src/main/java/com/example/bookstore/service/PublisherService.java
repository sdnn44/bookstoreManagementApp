package com.example.bookstore.service;

import com.example.bookstore.model.Publisher;
import com.example.bookstore.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll()
                .stream()
                .map(Publisher::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Publisher> getPublisherById(Long id) {
        return publisherRepository.findById(id).map(Publisher::fromEntity);
    }
}
