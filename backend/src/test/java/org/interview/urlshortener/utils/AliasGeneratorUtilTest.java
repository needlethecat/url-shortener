package org.interview.urlshortener.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AliasGeneratorUtilTest
{
	@Test
	void generateAlias_shouldNotBeNull()
	{
		assertNotNull(AliasGeneratorUtil.generateAlias());
	}

	@Test
	void generateAlias_shouldGenerateStringOfCorrectLength()
	{
		assertEquals(8, AliasGeneratorUtil.generateAlias().length());
	}

	@Test
	void generateAlias_shouldGenerateAlphaNumericString()
	{
		String alias = AliasGeneratorUtil.generateAlias();
		assertTrue(alias.matches("^[a-zA-Z0-9]*$"));
	}

	@Test
	void generateAlias_shouldGenerateUniqueStringsForSampleSize()
	{
		Set<String> uniqueStrings = new HashSet<String>();

		for (int i = 0; i < 1000; i++)
		{
			String alias = AliasGeneratorUtil.generateAlias();
			uniqueStrings.add(alias);
		}

		assertEquals(1000, uniqueStrings.size());
	}
}