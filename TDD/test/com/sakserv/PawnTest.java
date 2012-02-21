package com.sakserv;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PawnTest {

	@Test
	public void testCreate() {
		
		String whitePawnColor = "white";
		Pawn whitePawn = new Pawn();
		whitePawn.setColor(whitePawnColor);
		assertEquals("white", whitePawn.getColor());
		
		String blackPawnColor = "black";
		Pawn blackPawn = new Pawn();
		blackPawn.setColor(blackPawnColor);
		assertEquals("black", blackPawn.getColor());
	}

}
