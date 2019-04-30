package dev.shashwat.brickgame.entities.bricks;

import dev.shashwat.brickgame.Game;
import dev.shashwat.brickgame.entities.Entity;
import dev.shashwat.brickgame.gfx.Assets;

import java.awt.*;

public class BrickTwo extends Entity {
    private Game game;
    public BrickTwo(Game game) {
        super(Game.WIDTH-10,(Game.HEIGHT/2)-25);
        this.game = game;
    }
    public void tick(){
        if(game.getKeyManager().up_bricktwo && y>0){
                y -= 5;
        }
        if(game.getKeyManager().down_bricktwo && y+50<Game.HEIGHT){
                y += 5;
        }
    }
    public void render(Graphics g){
        g.drawImage(Assets.brick,(int)x,(int)y,null);
    }
}
