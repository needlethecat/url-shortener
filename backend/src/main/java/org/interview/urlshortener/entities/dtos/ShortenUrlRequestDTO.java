package org.interview.urlshortener.entities.dtos;

public record ShortenUrlRequestDTO(
		String fullUrl,
		String customAlias
) {}
