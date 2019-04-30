package dev.shashwat.brickgame.entities;

import dev.shashwat.brickgame.Game;
import dev.shashwat.brickgame.gfx.Assets;
import dev.shashwat.brickgame.states.GameState;
import dev.shashwat.brickgame.states.State;
import java.awt.*;

public class Ball extends Entity {


    private Game game;
    private double xspeed;
    private double yspeed;
    private GameState currentState;
    public Ball(Game game,double x, float y, GameState state) {
        super(x, y);
        this.game = game;
        xspeed = 3;
        yspeed = 3;
        this.currentState = state;
    }

    @Override
    public void tick() {
        if((Game.HEIGHT-1<y && y<Game.HEIGHT+5) || (-5 >y && y < 2)){
            yspeed = -yspeed;
            y += yspeed;
            x += xspeed;
        }else if(x>Game.WIDTH - 7 || x<0+7){
            State.setCurrentState(game.getOverState());
        }else if(((x <= Game.WIDTH - 15  && x >= Game.WIDTH - 20) && (y > currentState.getBrickTwo().y && y < currentState.getBrickTwo().y + 50 )) ){
            xspeed = -xspeed;
            y -= yspeed;
            x += xspeed;
        }else if((x > 7 && x < 11) && (y > currentState.getBrickOne().y && y < currentState.getBrickOne().y  + 50)){
            xspeed = -xspeed;
            y += yspeed;
            x += xspeed;
        }
        else{
            if(yspeed > 0) {
                y += yspeed;
                x += xspeed;
            }
            else if(yspeed < 0){
                y += yspeed;
                x += xspeed;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.ball,(int)x,(int)y,null);
    }
}
