package org.sakserv.chess;

import java.util.ArrayList;


/**
 * Creates a chess board instance
 * @author Shane Kumpf
 *
 */
public class Board {
	
	final static int STARTING_PIECE_COUNT = 0;
	private ArrayList<Pawn> currentPieces = new ArrayList<Pawn>();
	int numberOfPieces;
	
	Board() {
		numberOfPieces = STARTING_PIECE_COUNT;
	}
	
	public int getNumberOfPieces() {
		return numberOfPieces;
	}
	
	public void incrementPieceCount() {
		numberOfPieces++;
	}
	
	public void addPieceToCurrentPieces(Pawn pawn) {
		currentPieces.add(pawn);
	}
	
	public Pawn addPawn(String color){
		Pawn newPawn = new Pawn(color);
		incrementPieceCount();
		addPieceToCurrentPieces(newPawn);
		return newPawn;
	}
	
	public ArrayList<Pawn> getCurrentPieces() {
		return currentPieces;
	}

}
