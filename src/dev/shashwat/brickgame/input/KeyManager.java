package dev.shashwat.brickgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    protected boolean[] keys;
    public boolean up_brickone,down_brickone,up_bricktwo,down_bricktwo;

    public void tick(){
        up_brickone = keys[KeyEvent.VK_W];
        down_brickone = keys[KeyEvent.VK_S];
        up_bricktwo = keys[KeyEvent.VK_UP];
        down_bricktwo = keys[KeyEvent.VK_DOWN];
    }

    public KeyManager() {
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }
    public boolean isPressed(){
        for(int i=0;i<keys.length;i++){
            if(keys[i]==true){
                return true;
            }
        }
        return false;
    }
}
