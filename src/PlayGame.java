
public class PlayGame {

	public static void main(String[] args) {
		TicTacGame play=new TicTacGame();
		play.initializegame();
		System.out.println("Winner is"+play.startgame());
	}

}
