package dev.shashwat.brickgame.states;

import com.sun.javafx.css.converters.FontConverter;
import dev.shashwat.brickgame.Game;
import dev.shashwat.brickgame.gfx.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class OverState extends State {
    public OverState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        if(game.getKeyManager().isPressed()){
            GameState newState = new GameState(game);
            State.setCurrentState(newState);

        }
    }

    @Override
    public void render(Graphics g) {
            g.drawImage(Assets.theend, -40,0,null);
            g.setColor(Color.WHITE);
            g.drawString("PRESS ANY KEY TO CONTINUE!",100,Game.HEIGHT - 30);
    }


}
