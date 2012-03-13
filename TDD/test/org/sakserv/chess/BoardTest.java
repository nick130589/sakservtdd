package org.sakserv.chess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.sakserv.chess.Board;


public class BoardTest {

	@Test
	public void testCreate() {
		
		// Create Board object and currentPieces array
		Board board = new Board();
		ArrayList<Pawn> currentPieces = board.getCurrentPieces();
		
		// Get number of peices, assume 16 at start
		assertEquals(16, board.getNumberOfPieces());
		assertEquals(16, currentPieces.size());
		
	}

}
