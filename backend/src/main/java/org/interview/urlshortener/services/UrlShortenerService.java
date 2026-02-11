package org.interview.urlshortener.services;

import lombok.AllArgsConstructor;
import org.interview.urlshortener.entities.ShortUrl;
import org.interview.urlshortener.entities.dtos.ShortUrlDTO;
import org.interview.urlshortener.repositories.UrlShortenerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UrlShortenerService
{
	private final UrlShortenerRepository urlShortenerRepository;

	public List<ShortUrlDTO> getAllUrls()
	{
		return StreamSupport
				.stream(urlShortenerRepository.findAll().spliterator(), false)
				.map(url -> new ShortUrlDTO(
						url.getAlias(),
						url.getOriginalUrl()))
				.toList();
	}

	public ShortUrlDTO createShortUrl(ShortUrlDTO shortUrlDTO)
	{
		ShortUrl shortUrl = urlShortenerRepository.save(
				new ShortUrl(shortUrlDTO.alias(), shortUrlDTO.originalUrl()));
		return new ShortUrlDTO(shortUrl.getAlias(), shortUrl.getOriginalUrl());
	}
}
