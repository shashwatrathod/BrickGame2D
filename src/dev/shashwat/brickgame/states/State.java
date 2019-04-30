package dev.shashwat.brickgame.states;

import dev.shashwat.brickgame.Game;

import java.awt.Graphics;

public abstract class State {

	private static State currentState  = null;

	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentState) {
		State.currentState = currentState;
	}

	protected Game game;

	public State(Game game) {
		this.game = game;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
