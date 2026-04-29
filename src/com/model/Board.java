package com.model;

public class Board {
	public int size;
	public playingpiece[][] board ;
	
	public Board(int size){
		this.size=size;
		board=new playingpiece[size][size];
	}
	
	public boolean addpiece(int row,int column,playingpiece playingpiece) {
		if(board[row][column]!=null) {
			return false;
		}
		board[row][column]=playingpiece;
		return true;
	}
	public boolean isfreecell() {
		for(int i=0;i<size;i++) {
			for (int j = 0; j < size; j++) {
				if(board[i][j]==null) {
					return true;
				}
			}
		}
		return false;
	}

	public void printboard() {
		for(int i=0;i<size;i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j] != null ? "|" + board[i][j].pieceType +"|" : "| |");
			}
			System.out.println("");
		}
	}	
}