class Knight implements Piece {
	int x;
	int y;
	boolean isWhite;
	
	public Knight(int x, int y, boolean isWhite) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}
	
	@Override
	public boolean move(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		if (Math.abs(x1-x) + Math.abs(y1-y) == 3 && Math.abs(x1-x) > 0 && Math.abs(y1-y) > 0) {
			Board.pieces[x1][y1] = new Knight(x1,y1,isWhite);
			Board.pieces[x][y] = new Blank();
			return true;
		}
		return false;
	}

	@Override
	public boolean capture(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		if(Board.pieces[x1][y1].getTeam()) {
			if (Math.abs(x1-x) + Math.abs(y1-y) == 3 && Math.abs(x1-x) > 0 && Math.abs(y1-y) > 0 && !isWhite) {
				Board.pieces[x1][y1] = new Knight(x1,y1,false);
				Board.pieces[x][y] = new Blank();
				return true;
			}
		} else {
			if (Math.abs(x1-x) + Math.abs(y1-y) == 3 && Math.abs(x1-x) > 0 && Math.abs(y1-y) > 0 && isWhite) {
				Board.pieces[x1][y1] = new Knight(x1,y1,true);
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
		if(p[x1][y1].getTeam()) {
			if (Math.abs(x1-x) + Math.abs(y1-y) == 3 && Math.abs(x1-x) > 0 && Math.abs(y1-y) > 0 && !isWhite) {
				p[x1][y1] = new Knight(x1,y1,false);
				p[x][y] = new Blank();
				return true;
			}
		} else {
			if (Math.abs(x1-x) + Math.abs(y1-y) == 3 && Math.abs(x1-x) > 0 && Math.abs(y1-y) > 0 && isWhite) {
				p[x1][y1] = new Knight(x1,y1,true);
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
		if (Math.abs(x1-x) + Math.abs(y1-y) == 3 && Math.abs(x1-x) > 0 && Math.abs(y1-y) > 0) {
			p[x1][y1] = new Knight(x1,y1,isWhite);
			p[x][y] = new Blank();
			return true;
		}
		return false;
	}
	
	@Override
	public String getType() {
		return "Knight";
	}

	@Override
	public boolean getTeam() {
		return isWhite;
	}
	
	@Override
	public Knight clone() {
		return new Knight(x,y,isWhite);
	}
	
	@Override
	public int[] getLoc() {
		return new int[] {x,y};
	}
}