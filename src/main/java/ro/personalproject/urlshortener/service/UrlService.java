package ro.personalproject.urlshortener.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.personalproject.urlshortener.entity.Url;
import ro.personalproject.urlshortener.repository.UrlRepository;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 6;
    private final Random random = new Random();

    public String shortenUrl(String originalUrl) {
        String shortCode = generateShortCode();

        while (urlRepository.existsByShortCode(shortCode)) {
            shortCode = generateShortCode();
        }

        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);

        // createdAd is automatically set from @PrePersist
        urlRepository.save(url);
        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        return urlRepository.findByShortCode(shortCode)
                .map(Url::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("Url not found or expired"));
    }

    private String generateShortCode() {
        StringBuilder code = new StringBuilder(SHORT_CODE_LENGTH);
        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return code.toString();
    }
}
