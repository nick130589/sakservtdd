package org.sakserv.chess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.sakserv.chess.Board;


public class BoardTest {

	@Test
	public void testCreate() {
		Board board = new Board();
		ArrayList<Pawn> currentPieces = board.getCurrentPieces();
		
		assertEquals(0, board.getNumberOfPieces());
		
		// Add white pawn
		Pawn whitePawn = board.addPawn(Pawn.WHITE);
		assertEquals(1, board.getNumberOfPieces());
		assertEquals(whitePawn, currentPieces.get(0));
		
		// Add black pawn
		Pawn blackPawn = board.addPawn(Pawn.BLACK);
		assertEquals(2, board.getNumberOfPieces());
		assertEquals(blackPawn, currentPieces.get(1));
		
	}

}