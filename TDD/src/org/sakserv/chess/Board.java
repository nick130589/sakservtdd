package org.sakserv.chess;

import java.util.ArrayList;


/**
 * Creates a chess board instance
 * @author Shane Kumpf
 *
 */
public class Board {
	
	final static int STARTING_PIECE_COUNT = 16;
	private ArrayList<Pawn> currentPieces = new ArrayList<Pawn>();
	int numberOfPieces;
	
	Board() {
		initialize();
		numberOfPieces = currentPieces.size();
	}
	
	public void initialize() {
		ArrayList<Pawn> firstRank = new ArrayList<Pawn>();
		firstRank = addPawnsToBoard(firstRank, Pawn.WHITE, STARTING_PIECE_COUNT/2);
		
		ArrayList<Pawn> seventhRank = new ArrayList<Pawn>(); 
		seventhRank = addPawnsToBoard(seventhRank, Pawn.BLACK, STARTING_PIECE_COUNT/2);
	}
	
	public ArrayList<Pawn> addPawnsToBoard(ArrayList<Pawn> boardRank, String color, int numberToAdd) {
		for (int i = 0; i<numberToAdd; i++) {
			boardRank.add(i, addPawn(color));
		}
		return boardRank;
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
