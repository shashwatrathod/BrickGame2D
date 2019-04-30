package dev.shashwat.brickgame.states;


import java.awt.Graphics;
import java.util.Random;

import dev.shashwat.brickgame.Game;
import dev.shashwat.brickgame.entities.Ball;
import dev.shashwat.brickgame.entities.bricks.BrickOne;
import dev.shashwat.brickgame.entities.bricks.BrickTwo;

public class GameState extends State {

	protected BrickOne brickOne;
	protected BrickTwo brickTwo;
	protected Ball ball;

	public GameState(Game game) {
		super(game);
		Random rand = new Random();
		brickOne = new BrickOne(game);
		brickTwo = new BrickTwo(game);
		ball = new Ball(game,rand.nextInt(100)+(Game.WIDTH/2-50),rand.nextInt(100)+(Game.HEIGHT/2-50), this);
	}

	@Override
	public void tick() {
		brickOne.tick();
		brickTwo.tick();
		ball.tick();
	}

	@Override
	public void render(Graphics g) {
		brickOne.render(g);
		brickTwo.render(g);
		ball.render(g);
	}

	public BrickOne getBrickOne() {
		return brickOne;
	}

	public BrickTwo getBrickTwo() {
		return brickTwo;
	}
}
