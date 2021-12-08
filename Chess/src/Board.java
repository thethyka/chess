import java.util.*;

public class Board {
	
	static Piece[][] pieces = new Piece[8][8];
	
	public Board() {
		for (Piece[] p : pieces) {
			Arrays.fill(p, new Blank());
		}
		setPieces();
	}
	
	public static void showBoard() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				System.out.print(pieces[i][j].getType().substring(0,2));
				if(!pieces[i][j].getType().equals("Blank") && pieces[i][j].getTeam()) {
					System.out.print("*  ");
				} else {
				System.out.print("   ");
				}
			}
			System.out.println("\n");
		}
		System.out.println();

	}
	
	public static void play() {
		new Board();
		while(true) {
			makeMove(true);
			makeMove(false);
		}
	}
	
	public static boolean makeMove(boolean isWhite) {
		return false;
	}
	
	public static void setPieces() {
		for (int i = 0; i < 8; i++) {
			pieces[1][i] = new Pawn(1,i, true);
			pieces[6][i] = new Pawn(6,i, false);
		}

		
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public static void main(String[] args) {
		new Board();
		pieces[1][4].move(2,4);
		showBoard();
	}
	
}
