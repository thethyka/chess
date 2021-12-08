class Blank implements Piece {

	
	@Override
	public boolean move(int x1, int y1) {
		return false;
	}


	@Override
	public boolean capture(int x1, int y1) {
		return false;
	}
	
	@Override
	public boolean capture(int x1, int y1, Piece[][] p) {
		return false;
	}


	@Override
	public String getType() {
		return "Blank";
	}
	
	@Override
	public boolean getTeam() {
		throw new IllegalArgumentException("cant get team of blank space");
	}
	
	@Override
	public Blank clone() {
		return new Blank();
	}
	
	@Override
	public int[] getLoc() {
		throw new IllegalArgumentException("blank stores no location");
	}
	
	@Override
	public boolean move(int x, int y, Piece[][] p) {
		return false;
	}
}