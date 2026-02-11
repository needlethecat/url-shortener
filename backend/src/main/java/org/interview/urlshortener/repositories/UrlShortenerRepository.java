package org.interview.urlshortener.repositories;

import org.interview.urlshortener.entities.ShortUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends CrudRepository<ShortUrl, String>
{
}
