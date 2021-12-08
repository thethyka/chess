
public class Rules {

	public static boolean inBounds(int x,int y) {
		return (x>=0 && x<=7 && y>=0 && y<=7);
	}
	
	public static boolean putsInCheck(int x, int y, King k) {
		
		Piece[][] p = makeClone();
		
		p[x][y] = new King(x,y, k.getTeam());
		p[k.getLoc()[0]][k.getLoc()[1]] = new Blank();
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(p[i][j].capture(x, y, p)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean inCheck(boolean isWhite) {
		King k = findKing(isWhite);
		Piece[][] p = makeClone();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(p[i][j].capture(k.getLoc()[0], k.getLoc()[1], p)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean staleMate(boolean isWhite) {
		King k = findKing(isWhite);
		if(inCheck(isWhite)) {return false;}
		
		Piece[][] p = makeClone();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(p[k.getLoc()[0]][k.getLoc()[1]].move(i, j, p) || (p[k.getLoc()[0]][k.getLoc()[1]].capture(i, j, p))) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	public static boolean checkMate(boolean isWhite) {
		
		King k = findKing(isWhite);
		
		if(!inCheck(isWhite)) {return false;}
		
		Piece[][] p = makeClone();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(p[k.getLoc()[0]][k.getLoc()[1]].move(i, j, p) || (p[k.getLoc()[0]][k.getLoc()[1]].capture(i, j, p))) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static King findKing(boolean isWhite) {
		King k = null;
		Piece[][] p = makeClone();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(p[i][j].getType().equals("King") && p[i][j].getTeam() == isWhite) {
					k = (King) p[i][j];
				}
			}
		}
		if(k == null) {
			throw new IllegalArgumentException("king not found for team" + (isWhite ? "white" : "black"));
		}
		return k;
	}
	
	public static Piece[][] makeClone() {
		Piece[][] p = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				p[i][j] = Board.pieces[i][j].clone();
			}
		}
		return p;
	}
}
