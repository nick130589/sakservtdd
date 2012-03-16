package org.sakserv.scratch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharacterTest {
	
	@Test
	public void testWhitespace() {
		assertEquals(true, Character.isWhitespace('\t'));
		assertEquals(true, Character.isWhitespace('\n'));
		assertEquals(true, Character.isWhitespace(' '));
	}

	@Test
	public void testJavaIdentifiers() {
		
		assertEquals(true, Character.isJavaIdentifierStart('A'));
		assertEquals(true, Character.isJavaIdentifierPart('A'));
		
		assertEquals(true, Character.isJavaIdentifierStart('B'));
		assertEquals(true, Character.isJavaIdentifierPart('6'));
	}
}
