class Bishop implements Piece {
	int x;
	int y;
	boolean isWhite;
	
	
	public Bishop(int x, int y, boolean isWhite) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}
	
	@Override
	public boolean move(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (!Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		
		if(Math.abs(x1-x) == Math.abs(y1-y)) {
			int diff = Math.abs(x1-x);
			for(int i = 1; i < diff; i++) {
				if(x>x1 && y>y1) {
					if(!Board.pieces[x-i][y-i].getType().equals("Blank")) {
						System.out.println("a");
						return false;
					}
				} else if (x>x1 && y<y1) {
					if(!Board.pieces[x-i][y+i].getType().equals("Blank")) {
						System.out.println("b");
						return false;
					}
				} else if (x<x1 && y>y1) {
					if(!Board.pieces[x+i][y-i].getType().equals("Blank")) {
						System.out.println("c");
						return false;
					}
				} else if (x<x1 && y<y1) {
					if(!Board.pieces[x+i][y+i].getType().equals("Blank")) {
						System.out.println("d");
						return false;
					}
				}
			}
			Board.pieces[x1][y1] = new Bishop(x1,y1,isWhite);
			Board.pieces[x][y] = new Blank();
			return true;
		}
		return false;
	}

	@Override
	public boolean capture(int x1, int y1) {
		if (!Rules.inBounds(x1,y1)) {return false;}
		if (Board.pieces[x1][y1].getType().equals("Blank")) {return false;}
		
		if(Math.abs(x1-x) == Math.abs(y1-y)) {
			int diff = Math.abs(x1-x);
			for(int i = 1; i < diff; i++) {
				if(x>x1 && y>y1) {
					if(!Board.pieces[x-i][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (x>x1 && y<y1) {
					if(!Board.pieces[x-i][y+i].getType().equals("Blank")) {
						return false;
					}
				} else if (x<x1 && y>y1) {
					if(!Board.pieces[x+i][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (x<x1 && y<y1) {
					if(!Board.pieces[x+i][y+i].getType().equals("Blank")) {
						return false;
					}
				}
			}
			if(Board.pieces[x1][y1].getTeam()) {
				if(!isWhite) {
					Board.pieces[x1][y1] = new Bishop(x1,y1,false);
					Board.pieces[x][y] = new Blank();
					return true;
				}
			} else {
				if(isWhite) {
					Board.pieces[x1][y1] = new Bishop(x1,y1,true);
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
		
		if(Math.abs(x1-x) == Math.abs(y1-y)) {
			int diff = Math.abs(x1-x);
			for(int i = 1; i < diff; i++) {
				if(x>x1 && y>y1) {
					if(!p[x-i][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (x>x1 && y<y1) {
					if(!p[x-i][y+i].getType().equals("Blank")) {
						return false;
					}
				} else if (x<x1 && y>y1) {
					if(!p[x+i][y-i].getType().equals("Blank")) {
						return false;
					}
				} else if (x<x1 && y<y1) {
					if(!p[x+i][y+i].getType().equals("Blank")) {
						return false;
					}
				}
			}
			if(p[x1][y1].getTeam()) {
				if(!isWhite) {
					p[x1][y1] = new Bishop(x1,y1,false);
					p[x][y] = new Blank();
					return true;
				}
			} else {
				if(isWhite) {
					p[x1][y1] = new Bishop(x1,y1,true);
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
		
		if(Math.abs(x1-x) == Math.abs(y1-y)) {
			int diff = Math.abs(x1-x);
			for(int i = 1; i < diff; i++) {
				if(x>x1 && y>y1) {
					if(!p[x-i][y-i].getType().equals("Blank")) {
						System.out.println("a");
						return false;
					}
				} else if (x>x1 && y<y1) {
					if(!p[x-i][y+i].getType().equals("Blank")) {
						System.out.println("b");
						return false;
					}
				} else if (x<x1 && y>y1) {
					if(!p[x+i][y-i].getType().equals("Blank")) {
						System.out.println("c");
						return false;
					}
				} else if (x<x1 && y<y1) {
					if(!p[x+i][y+i].getType().equals("Blank")) {
						System.out.println("d");
						return false;
					}
				}
			}
			p[x1][y1] = new Bishop(x1,y1,isWhite);
			p[x][y] = new Blank();
			return true;
		}
		return false;
	}

	@Override
	public String getType() {
		return "Bishop";
	}
	
	@Override
	public boolean getTeam() {
		return isWhite;
	}
	
	@Override
	public Bishop clone() {
		return new Bishop(x,y,isWhite);
	}
	
	@Override
	public int[] getLoc() {
		return new int[] {x,y};
	}
}