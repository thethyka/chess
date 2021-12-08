class King implements Piece {
	int x;
	int y;
	boolean isWhite;
	
	public King(int x, int y, boolean isWhite) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}
	
	@Override
	public boolean move(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		
		if(Math.abs(x1-x) <= 1 && Math.abs(y1-y) <= 1) {
			if(!Rules.putsInCheck(x1,y1, this)) {
				Board.pieces[x1][y1] = new King(x1,y1, isWhite);
				Board.pieces[x][y] = new Blank();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean capture(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		
		if(Math.abs(x1-x) <= 1 && Math.abs(y1-y) <= 1) {
			if(!Rules.putsInCheck(x1,y1, this)) {
				if(Board.pieces[x1][y1].getTeam()) {
					if(!isWhite) {
						Board.pieces[x1][y1] = new King(x1,y1,false);
						Board.pieces[x][y] = new Blank();
						return true;
					}
				} else {
					if(isWhite) {
						Board.pieces[x1][y1] = new King(x1,y1,true);
						Board.pieces[x][y] = new Blank();
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean capture(int x1, int y1, Piece[][] p) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (p[x1][y1].getType().equals("Blank")) {return false;}
		
		if(Math.abs(x1-x) <= 1 && Math.abs(y1-y) <= 1) {
			if(!Rules.putsInCheck(x1,y1, this)) {
				if(p[x1][y1].getTeam()) {
					if(!isWhite) {
						p[x1][y1] = new King(x1,y1,false);
						p[x][y] = new Blank();
						return true;
					}
				} else {
					if(isWhite) {
						p[x1][y1] = new King(x1,y1,true);
						p[x][y] = new Blank();
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean move(int x1, int y1, Piece[][] p) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!p[x1][y1].getType().equals("Blank")) {return false;}
		
		if(Math.abs(x1-x) <= 1 && Math.abs(y1-y) <= 1) {
			if(!Rules.putsInCheck(x1,y1, this)) {
				p[x1][y1] = new King(x1,y1, isWhite);
				p[x][y] = new Blank();
				return true;
			}
		}
		return false;
	}

	@Override
	public String getType() {
		return "King";
	}
	
	@Override
	public boolean getTeam() {
		return isWhite;
	}
	
	@Override
	public King clone() {
		return new King(x,y,isWhite);
	}
	
	@Override
	public int[] getLoc() {
		return new int[] {x,y};
	}
}