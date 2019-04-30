package dev.shashwat.brickgame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int height = 150;
    private static final int width = 200;
    public static BufferedImage brick, ball, theend, startgame;

    public static void init(){
            brick = ImageLoader.loadImage("/textures/brick.png");
            ball = ImageLoader.loadImage("/textures/ball.png");
            theend = ImageLoader.loadImage("/textures/theend.gif");
            startgame = ImageLoader.loadImage("/textures/startgame.png");
        }
}