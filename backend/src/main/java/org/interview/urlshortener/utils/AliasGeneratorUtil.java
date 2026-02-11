package org.interview.urlshortener.utils;

import java.security.SecureRandom;

public class AliasGeneratorUtil
{
	private static final int ALIAS_LENGTH = 8;
	private static final String ALLOWED_CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final SecureRandom SECURE_RANDOM = new SecureRandom();

	public static String generateAlias()
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < ALIAS_LENGTH; i++)
		{
			int randomCharacterIndex = SECURE_RANDOM.nextInt(ALLOWED_CHARACTERS.length());
			stringBuilder.append(ALLOWED_CHARACTERS.charAt(randomCharacterIndex));
		}
		return stringBuilder.toString();
	}
}
