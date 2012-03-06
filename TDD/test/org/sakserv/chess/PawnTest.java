package org.sakserv.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sakserv.chess.Pawn;

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
	
	@Test
	public void testCreatePawnNoColor() {
		Pawn noColorPawn = new Pawn();
	}

}
