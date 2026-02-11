package org.interview.urlshortener.controllers;

import lombok.AllArgsConstructor;
import org.interview.urlshortener.entities.dtos.ShortUrlDTO;
import org.interview.urlshortener.services.UrlShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UrlShortenerController
{
	private final UrlShortenerService urlShortenerService;

	@GetMapping(Urls.UrlShortener.Get.URLS)
	public ResponseEntity<List<ShortUrlDTO>> getUrls()
	{
		return ResponseEntity.ok(urlShortenerService.getAllUrls());
	}

	@PostMapping(Urls.UrlShortener.Post.SHORTEN_URL)
	public ResponseEntity<ShortUrlDTO> createShortUrl(@RequestBody ShortUrlDTO shortUrlDTO)
	{
		ShortUrlDTO createdShortUrlDTO = urlShortenerService.createShortUrl(shortUrlDTO);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(createdShortUrlDTO);
	}
}
