package org.interview.urlshortener.entities.dtos;

public record ShortUrlDTO(
		String alias,
		String originalUrl
) { }
