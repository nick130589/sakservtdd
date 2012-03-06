package org.sakserv.scratch;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScratchTest {

	@Test
	public void testChars() {
		char capitalA = 'A';
		assertEquals(65, capitalA); // 0-65,535 Unicode
		assertEquals('\u0041', capitalA); // Unicode
		assertEquals('\101', capitalA); // Octal
		assertEquals("abcd", "ab".concat("cd"));
	}

}
