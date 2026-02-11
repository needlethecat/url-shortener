package org.interview.urlshortener.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash("short_url")
public class ShortUrl
{
	@Id
	private String alias;

	private String originalUrl;
}
