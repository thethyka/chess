class Pawn implements Piece {
	int x;
	int y;
	boolean isWhite;
	
	public Pawn(int x, int y, boolean isWhite) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}
	
	@Override
	public boolean move(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		
		if (x == 1 && isWhite && x1 == x+2 && y1 == y) {
			if (!Board.pieces[x+1][y].getType().equals("Blank")) {return false;}
			Board.pieces[x1][y1] = new Pawn(x1,y1, true);
			Board.pieces[x][y] = new Blank();
			return true;
		} else if (x == 6 && !isWhite && x1 == x-2 && y1 == y) {
			if (!Board.pieces[x-1][y].getType().equals("Blank")) {return false;}
			Board.pieces[x1][y1] = new Pawn(x1,y1, false);
			Board.pieces[x][y] = new Blank();
			return true;
		} else if (x1 == x+1 && y1 == y && isWhite) {
			Board.pieces[x1][y1] = new Pawn(x1,y1, true);
			Board.pieces[x][y] = new Blank();
			return true;
		} else if (x1 == x-1 && y1 == y && !isWhite) {
			Board.pieces[x1][y1] = new Pawn(x1,y1, false);
			Board.pieces[x][y] = new Blank();
			return true;
		}
		return false;
	}

	@Override
	public boolean capture(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		
		if(!Board.pieces[x1][y1].getTeam()) {
			if(x1 == x+1 && y1 == y+1 && isWhite || x1 == x+1 && y1 == y-1 && isWhite) {
				Board.pieces[x1][y1] = new Pawn(x1,y1,true);
				Board.pieces[x][y] = new Blank();
				return true;
			}
		} else if(Board.pieces[x1][y1].getTeam()) {
			if (x1 == x-1 && y1 == y+1 && !isWhite || x1 == x-1 && y1 == y-1 && !isWhite) {
				Board.pieces[x1][y1] = new Pawn(x1,y1,false);
				Board.pieces[x][y] = new Blank();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean capture(int x1, int y1, Piece[][] p) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (p[x1][y1].getType().equals("Blank")) {return false;}
		
		if(!p[x1][y1].getTeam()) {
			if(x1 == x+1 && y1 == y+1 && isWhite || x1 == x+1 && y1 == y-1 && isWhite) {
				p[x1][y1] = new Pawn(x1,y1,true);
				p[x][y] = new Blank();
				return true;
			}
		} else if(p[x1][y1].getTeam()) {
			if (x1 == x-1 && y1 == y+1 && !isWhite || x1 == x-1 && y1 == y-1 && !isWhite) {
				p[x1][y1] = new Pawn(x1,y1,false);
				p[x][y] = new Blank();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean move(int x1, int y1, Piece[][] p) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!p[x1][y1].getType().equals("Blank")) {return false;}
		
		if (x == 1 && isWhite && x1 == x+2 && y1 == y) {
			if (!p[x+1][y].getType().equals("Blank")) {return false;}
			p[x1][y1] = new Pawn(x1,y1, true);
			p[x][y] = new Blank();
			return true;
		} else if (x == 6 && !isWhite && x1 == x-2 && y1 == y) {
			if (!p[x-1][y].getType().equals("Blank")) {return false;}
			p[x1][y1] = new Pawn(x1,y1, false);
			p[x][y] = new Blank();
			return true;
		} else if (x1 == x+1 && y1 == y && isWhite) {
			p[x1][y1] = new Pawn(x1,y1, true);
			p[x][y] = new Blank();
			return true;
		} else if (x1 == x-1 && y1 == y && !isWhite) {
			p[x1][y1] = new Pawn(x1,y1, false);
			p[x][y] = new Blank();
			return true;
		}
		return false;
	}

	@Override
	public String getType() {
		return "Pawn";
	}
	
	@Override
	public boolean getTeam() {
		return isWhite;
	}
	
	@Override
	public Pawn clone() {
		return new Pawn(x,y,isWhite);
	}
	
	@Override
	public int[] getLoc() {
		return new int[] {x,y};
	}
	
//	@Override
//	public boolean canMove(int x, int y) {
//		return true;
//	}
	
}
