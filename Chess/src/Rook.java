class Rook implements Piece {
	int x;
	int y;
	boolean isWhite;
	
	public Rook(int x, int y, boolean isWhite) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}
	
	@Override
	public boolean move(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		
		if(x == x1 && Math.abs(y-y1) > 0) {
			int yDiff = Math.abs(y-y1);
			for(int i = 1; i < yDiff; i++) {
				if (y > y1) {
					if(!Board.pieces[x][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (y < y1) {
					if(!Board.pieces[x][y+i].getType().equals("Blank")) {
						return false;
					}
				}
			}
			Board.pieces[x1][y1] = new Rook(x1,y1,isWhite);
			Board.pieces[x][y] = new Blank();
			return true;
		} else if (y == y1 && Math.abs(x-x1) > 0) {
			int xDiff = Math.abs(x-x1);
			for (int i = 1; i < xDiff; i++) {
				if(x > x1) {
					if(!Board.pieces[x-1][y].getType().equals("Blank")) {
						return false;
					}
					
				} else if (x < x1) {
					if(!Board.pieces[x+1][y].getType().equals("Blank")) {
						return false;
					}
				}
			}
			Board.pieces[x1][y1] = new Rook(x1,y1,isWhite);
			Board.pieces[x][y] = new Blank();
			return true;
		}
		return false;
	}

	@Override
	public boolean capture(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		if(x == x1 && Math.abs(y-y1) > 0) {
			int yDiff = Math.abs(y-y1);
			for(int i = 1; i < yDiff; i++) {
				if (y > y1) {
					if(!Board.pieces[x][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (y < y1) {
					if(!Board.pieces[x][y+i].getType().equals("Blank")) {
						return false;
					}
				}
			}
			
			if(Board.pieces[x1][y1].getTeam()) {
				if(!isWhite) {
					Board.pieces[x1][y1] = new Rook(x1,y1,false);
					Board.pieces[x][y] = new Blank();
					return true;
				}
			} else {
				if(isWhite) {
					Board.pieces[x1][y1] = new Rook(x1,y1,true);
					Board.pieces[x][y] = new Blank();
					return true;
				}
			}
			
		} else if (y == y1 && Math.abs(x-x1) > 0) {
			int xDiff = Math.abs(x-x1);
			for (int i = 1; i < xDiff; i++) {
				if(x > x1) {
					if(!Board.pieces[x-1][y].getType().equals("Blank")) {
						return false;
					}
					
				} else if (x < x1) {
					if(!Board.pieces[x+1][y].getType().equals("Blank")) {
						return false;
					}
				}
			}
			
			if(Board.pieces[x1][y1].getTeam()) {
				if(!isWhite) {
					Board.pieces[x1][y1] = new Rook(x1,y1,false);
					Board.pieces[x][y] = new Blank();
					return true;
				}
			} else {
				if(isWhite) {
					Board.pieces[x1][y1] = new Rook(x1,y1,true);
					Board.pieces[x][y] = new Blank();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean capture(int x1, int y1, Piece[][] p) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (p[x1][y1].getType().equals("Blank")) {return false;}
		if(x == x1 && Math.abs(y-y1) > 0) {
			int yDiff = Math.abs(y-y1);
			for(int i = 1; i < yDiff; i++) {
				if (y > y1) {
					if(!p[x][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (y < y1) {
					if(!p[x][y+i].getType().equals("Blank")) {
						return false;
					}
				}
			}
			
			if(p[x1][y1].getTeam()) {
				if(!isWhite) {
					p[x1][y1] = new Rook(x1,y1,false);
					p[x][y] = new Blank();
					return true;
				}
			} else {
				if(isWhite) {
					p[x1][y1] = new Rook(x1,y1,true);
					p[x][y] = new Blank();
					return true;
				}
			}
			
		} else if (y == y1 && Math.abs(x-x1) > 0) {
			int xDiff = Math.abs(x-x1);
			for (int i = 1; i < xDiff; i++) {
				if(x > x1) {
					if(!p[x-1][y].getType().equals("Blank")) {
						return false;
					}
					
				} else if (x < x1) {
					if(!p[x+1][y].getType().equals("Blank")) {
						return false;
					}
				}
			}
			
			if(p[x1][y1].getTeam()) {
				if(!isWhite) {
					p[x1][y1] = new Rook(x1,y1,false);
					p[x][y] = new Blank();
					return true;
				}
			} else {
				if(isWhite) {
					p[x1][y1] = new Rook(x1,y1,true);
					p[x][y] = new Blank();
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean move(int x1, int y1, Piece[][] p) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!p[x1][y1].getType().equals("Blank")) {return false;}
		
		if(x == x1 && Math.abs(y-y1) > 0) {
			int yDiff = Math.abs(y-y1);
			for(int i = 1; i < yDiff; i++) {
				if (y > y1) {
					if(!p[x][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (y < y1) {
					if(!p[x][y+i].getType().equals("Blank")) {
						return false;
					}
				}
			}
			p[x1][y1] = new Rook(x1,y1,isWhite);
			p[x][y] = new Blank();
			return true;
		} else if (y == y1 && Math.abs(x-x1) > 0) {
			int xDiff = Math.abs(x-x1);
			for (int i = 1; i < xDiff; i++) {
				if(x > x1) {
					if(!p[x-1][y].getType().equals("Blank")) {
						return false;
					}
					
				} else if (x < x1) {
					if(!p[x+1][y].getType().equals("Blank")) {
						return false;
					}
				}
			}
			p[x1][y1] = new Rook(x1,y1,isWhite);
			p[x][y] = new Blank();
			return true;
		}
		return false;
	}
	
	@Override
	public String getType() {
		return "Rook";
	}
	
	@Override
	public boolean getTeam() {
		return isWhite;
	}
	
	@Override
	public Rook clone() {
		return new Rook(x,y,isWhite);
	}
	
	@Override
	public int[] getLoc() {
		return new int[] {x,y};
	}
}