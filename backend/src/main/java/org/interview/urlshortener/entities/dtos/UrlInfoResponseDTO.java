package org.interview.urlshortener.entities.dtos;

public record UrlInfoResponseDTO(
		String alias,
		String fullUrl,
		String shortUrl
) {}
