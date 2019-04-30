package dev.shashwat.brickgame;

import dev.shashwat.brickgame.gfx.Assets;
import dev.shashwat.brickgame.display.Display;
import dev.shashwat.brickgame.input.KeyManager;
import dev.shashwat.brickgame.states.GameState;
import dev.shashwat.brickgame.states.MenuState;
import dev.shashwat.brickgame.states.OverState;
import dev.shashwat.brickgame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable{
    private Display display;
    public static int WIDTH;
    public static int HEIGHT;
    private String TITLE;
    private boolean running;
    private BufferStrategy bs;
    private Graphics g;
    private Thread thread;
    private State gameState;
    private State overState;
    private State menuState;

    public State getGameState() {
        return gameState;
    }

    public State getOverState() {
        return overState;
    }

    private KeyManager keyManager;

    public Game(String TITLE, int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.TITLE = TITLE;
        keyManager = new KeyManager();
    }
    public void init(){
        display = new Display(TITLE,WIDTH,HEIGHT);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        gameState = new GameState(this);
        overState = new OverState(this);
        menuState = new MenuState(this);
        State.setCurrentState(menuState);
    }
    public void tick(){
        keyManager.tick();
        if(State.getCurrentState()!=null){
            State.getCurrentState().tick();
        }
    }
    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0,WIDTH,HEIGHT);

        //start draw
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        State.getCurrentState().render(g);
        //end
       bs.show();
       g.dispose();

    }
    public void run(){
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;
        while(running) {
        	now = System.nanoTime();
        	delta += (now-lastTime) / timePerTick; 
        	timer += now - lastTime ; 
        	lastTime  = now ;
        	
        	if(delta>=1) {
        		tick();
        		render();
        		ticks++;
        		delta--;
        	}
        	
        	if(timer>1000000000) {
        		System.out.println("FPS: "+ticks);
        		ticks = 0;
        		timer = 0;
        	}
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public synchronized void start(){
        if(!running) {
            running = true;
            thread = new Thread(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }
    }
    public synchronized void stop(){
        if(running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
