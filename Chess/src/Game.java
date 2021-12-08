
public class Game {
	private Board b;
	private Player p1;
	private Player p2;
	private boolean p1Turn;
	
	public Game() {
		b = new Board();
		b.setPieces();
		b.showBoard();
		p1Turn = true;
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		
	}
}
