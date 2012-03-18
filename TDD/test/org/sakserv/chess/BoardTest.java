package org.sakserv.chess;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


public class BoardTest {

	@Test
	public void testCreate() {
		Board board = new Board();
		List<Pawn> currentPieces = board.getCurrentPieces();
		
		assertEquals(16, board.getNumberOfPieces());
		
		// Add white pawn
		Pawn whitePawn = board.addPawn(Pawn.WHITE);
		assertEquals(17, board.getNumberOfPieces());
		assertEquals(whitePawn, currentPieces.get(16));
		
		// Add black pawn
		Pawn blackPawn = board.addPawn(Pawn.BLACK);
		assertEquals(18, board.getNumberOfPieces());
		assertEquals(blackPawn, currentPieces.get(17));
		
	}

}