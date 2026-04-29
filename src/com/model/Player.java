package com.model;

public class Player {
	public String name;
	public playingpiece playingpiece;
	public Player( String name, playingpiece playingpiece) {
		this.name=name;
		this.playingpiece=playingpiece;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public playingpiece getPlayingpiece() {
		return playingpiece;
	}
	public void setPlayingpiece(playingpiece playingpiece) {
		this.playingpiece = playingpiece;
	}
}