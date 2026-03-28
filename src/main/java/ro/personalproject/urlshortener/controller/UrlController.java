package ro.personalproject.urlshortener.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.personalproject.urlshortener.service.UrlService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/url")
    public ResponseEntity<String> shortenUrl(@Valid @RequestBody UrlRequest request) {
        String shortCode = urlService.shortenUrl(request.originalUrl());

        String shortenedUrl = "http://localhost:8080/" + shortCode;

        return ResponseEntity.ok(shortenedUrl);
    }

    @GetMapping("/{shortCode:[^\\.]+}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode) {
        String originalUrl = urlService.getOriginalUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}
