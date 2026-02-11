package org.interview.urlshortener.controllers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class Urls
{

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class UrlShortener
	{

		@NoArgsConstructor(access = AccessLevel.PRIVATE)
		public static final class Get
		{
			public static final String REDIRECT_URL = "/{alias}";
			public static final String URLS = "/urls";
		}

		@NoArgsConstructor(access = AccessLevel.PRIVATE)
		public static final class Post
		{
			public static final String SHORTEN_URL = "/shorten";
		}

		@NoArgsConstructor(access = AccessLevel.PRIVATE)
		public static final class Delete
		{
			public static final String DELETE_URL = "/{alias}";
		}
	}
}
