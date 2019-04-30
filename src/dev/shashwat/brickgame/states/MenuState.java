package dev.shashwat.brickgame.states;

import dev.shashwat.brickgame.Game;
import dev.shashwat.brickgame.gfx.Assets;

import java.awt.*;

public class MenuState extends State{

    public MenuState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        if(game.getKeyManager().isPressed()){
            State.setCurrentState(new GameState(game));
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.startgame,10,0,null);
        g.setColor(Color.WHITE);
        g.drawString("Press any key to start!",150,Game.HEIGHT - 30);
    }
}
