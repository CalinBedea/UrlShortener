package ro.personalproject.urlshortener.controller;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record UrlRequest(
        @NotBlank(message = "Link cannot be blank!")
        @URL(message = "Please enter a valid web address!")
        String originalUrl
) {
}
