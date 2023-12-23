package com.example.moviemetricsv2.api.service;

import com.example.moviemetricsv2.api.model.MovieClassification;
import com.example.moviemetricsv2.api.repository.IMovieClassificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieClassificationService {
    private final IMovieClassificationRepository movieClassificationRepository;

    public MovieClassification findOrCreate(String name) {
        Optional<MovieClassification> movieClassification = movieClassificationRepository.findByNameIgnoreCase(name);

        return movieClassification.orElseGet(() -> movieClassificationRepository.save(
                MovieClassification.builder()
                        .name(name)
                        .build()
        ));
    }

    public void createIfNotFound(String name) {
        if (!movieClassificationRepository.existsByNameIgnoreCase(name))
            movieClassificationRepository.save(
                    MovieClassification.builder()
                            .name(name)
                            .build()
            );
    }
}

