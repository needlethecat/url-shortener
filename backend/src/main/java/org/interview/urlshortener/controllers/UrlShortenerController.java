package org.interview.urlshortener.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.interview.urlshortener.entities.dtos.ShortenUrlRequestDTO;
import org.interview.urlshortener.entities.dtos.ShortenUrlResponseDTO;
import org.interview.urlshortener.entities.dtos.UrlInfoResponseDTO;
import org.interview.urlshortener.services.UrlShortenerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UrlShortenerController
{
	private final UrlShortenerService urlShortenerService;

	// TODO need to review the API contract and make sure everything matches, doesnt currently

	@GetMapping(Urls.UrlShortener.Get.URLS)
	public ResponseEntity<List<UrlInfoResponseDTO>> getUrls(HttpServletRequest request)
	{
		return ResponseEntity.ok(urlShortenerService.getAllUrls(getBaseUrl(request)));
	}

	/*
	* Request (path): alias
	* Response: 302 and 404 depending
	* */
	@GetMapping(Urls.UrlShortener.Get.REDIRECT_URL)
	public ResponseEntity<Void> getRedirectUrl(@PathVariable String alias)
	{
		//TODO handle not found
		String fullUrl = urlShortenerService.getRedirectUrl(alias);
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.header(HttpHeaders.LOCATION, fullUrl)
				.build();
	}

	//TODO handle no fullUrl
	//TODO handle blank custom alias, but allow null custom alias
	@PostMapping(Urls.UrlShortener.Post.SHORTEN_URL)
	public ResponseEntity<ShortenUrlResponseDTO> createShortUrl(@RequestBody ShortenUrlRequestDTO shortenUrlRequestDTO,
																HttpServletRequest request)
	{
		ShortenUrlResponseDTO shortenUrlResponseDTO = urlShortenerService.createShortUrl(shortenUrlRequestDTO, getBaseUrl(request));
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(shortenUrlResponseDTO);
	}

	/*
	* Request (path): alias
	* Response: 204 or 404 depending
	* */
	public void deleteUrl()
	{
		//TODO implement
	}

	private String getBaseUrl(HttpServletRequest request)
	{
		return request.getScheme() + "://" +
				request.getServerName() +
				":" + request.getServerPort() + "/";
	}
}
