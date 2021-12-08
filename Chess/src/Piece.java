
public interface Piece {

	boolean move(int x1, int y1);
	boolean capture(int x1, int y1);
	String getType();
	boolean getTeam();
	Piece clone();
	int[] getLoc();
	boolean capture(int x1, int y1, Piece[][] p);
	boolean move(int x1, int y1, Piece[][] p);
	//boolean canMove(int x1, int y1);
	
}