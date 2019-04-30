package dev.shashwat.brickgame;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("BrickGame",400,500);
        game.start();
    }
}
