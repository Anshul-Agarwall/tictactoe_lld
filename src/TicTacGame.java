import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import com.model.*;

public class TicTacGame {
	Deque<Player> players;
	Board gameboard;
	
	public void initializegame() {
		players=new LinkedList<>();
		playingpiece crosspiece=new playingpieceX();
		Player player1=new Player("Player1",crosspiece);
		playingpiece circlepiece=new playingpieceO();
		Player player2=new Player("Player2",circlepiece);
		players.add(player1);
		players.add(player2);
//		players.add(player2);
		gameboard=new Board(3);
	}
	public String startgame() {
		boolean nowinner=true;
		while(nowinner) {
			Player currentplayer=players.removeFirst();
			if(!gameboard.isfreecell()) {
				nowinner=false;
				continue;
			}
			Scanner input=new Scanner(System.in);
			gameboard.printboard();
			System.out.println(currentplayer.name +"Enter [Row,Column]");
			String s=input.nextLine();
			String[] arr=s.split(",");
			int inputrow=Integer.valueOf((arr[0]));
			int inputcolumn=Integer.valueOf((arr[1]));
			
			boolean validmove=gameboard.addpiece(inputrow, inputcolumn,currentplayer.playingpiece);
			if(!validmove) {
				System.out.println("Incorect position choosen");
				players.addFirst(currentplayer);
			}
			players.addLast(currentplayer);
			boolean isWinner=checkforwinner(inputrow, inputcolumn,currentplayer.playingpiece.pieceType);
			if(isWinner) {
				return currentplayer.name;
			}
		}
		return "Tie";
	}
	private boolean checkforwinner(int inputrow, int inputcolumn, PieceType pieceType) {
		boolean rowmatch=true;
		boolean columnmatch=true;
		boolean diagonalmatch=true;
		boolean antidiagonalmatch=true;
		
		for (int i = 0; i < gameboard.size; i++) {
			if(gameboard.board[inputrow][i]==null || gameboard.board[inputrow][i].pieceType!=pieceType) {
				rowmatch=false;
			}
		}
		for (int i = 0; i < gameboard.size; i++) {
			if(gameboard.board[i][inputcolumn]==null || gameboard.board[i][inputcolumn].pieceType!=pieceType) {
				columnmatch=false;
			}
		}
		for (int i = 0,j=0; i < gameboard.size; i++,j++) {
			if(gameboard.board[i][j]==null || gameboard.board[i][j].pieceType!=pieceType) {
				diagonalmatch=false;
			}
		}
		for (int i = 0,j=gameboard.size-1; i < gameboard.size; i++,j--) {
			if(gameboard.board[i][j]==null || gameboard.board[i][j].pieceType!=pieceType) {
				antidiagonalmatch=false;
			}
		}
		return rowmatch||columnmatch||diagonalmatch||antidiagonalmatch;
	}
}
