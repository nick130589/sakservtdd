package org.sakserv.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PawnTest {
	
	private Pawn whitePawn = new Pawn(Pawn.WHITE);
	private Pawn blackPawn = new Pawn(Pawn.BLACK);
	
	@Test
	public void testGetColor() {
		assertEquals("white", whitePawn.getColor());
		assertEquals("black", blackPawn.getColor());
	}
	
	@Test
	public void testCreatePawnNoColor() {
		Pawn noColorPawn = new Pawn();
		assertEquals(Pawn.WHITE, noColorPawn.getColor());
	}
	
	@Test 
	public void testPawnToString() {
		assertEquals("P", blackPawn.toString());
		assertEquals("p", whitePawn.toString());
	}

}
