package org.interview.urlshortener.services;

import lombok.AllArgsConstructor;
import org.interview.urlshortener.entities.ShortUrl;
import org.interview.urlshortener.entities.dtos.ShortenUrlRequestDTO;
import org.interview.urlshortener.entities.dtos.ShortenUrlResponseDTO;
import org.interview.urlshortener.entities.dtos.UrlInfoResponseDTO;
import org.interview.urlshortener.repositories.UrlShortenerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UrlShortenerService
{
	private final UrlShortenerRepository urlShortenerRepository;

	public List<UrlInfoResponseDTO> getAllUrls(String baseUrl)
	{
		return StreamSupport
				.stream(urlShortenerRepository.findAll().spliterator(), false)
				.map(url -> new UrlInfoResponseDTO(
						url.getAlias(),
						url.getFullUrl(),
						baseUrl + url.getAlias()))
				.toList();
	}

	public String getRedirectUrl(String alias)
	{
		Optional<ShortUrl> shortUrl = urlShortenerRepository.findById(alias);
		if (shortUrl.isPresent())
		{
			return shortUrl.get().getFullUrl();
		}
		return ""; //TODO handle properly
	}

	public ShortenUrlResponseDTO createShortUrl(ShortenUrlRequestDTO shortenUrlRequestDTO, String baseUrl)
	{
		System.out.println(baseUrl);
		ShortUrl shortUrl = urlShortenerRepository.save(
				new ShortUrl(shortenUrlRequestDTO.customAlias(), shortenUrlRequestDTO.fullUrl()));
		return new ShortenUrlResponseDTO(baseUrl + shortUrl.getAlias());
	}
}
