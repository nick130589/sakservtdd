package org.sakserv.chess;


/**
 * Create a Pawn of either black or white.
 * White is the default if not supplied.
 * @author Shane Kumpf
 *
 */
public class Pawn {
	
	public static final String WHITE = "white";
	public static final String BLACK = "black";
	
	private String color;
	
	Pawn() {
		this.color = WHITE;
	}
	
	Pawn(String color){
		this.color = color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return color;
	}

}
