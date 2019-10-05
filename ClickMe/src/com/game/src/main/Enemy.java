package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

class Enemy {

    private double x, y;
    static final int BOUND = 100;


    private int speedX , speedY;

    private BufferedImage img;

    private com.game.src.main.Game game;


    Enemy(double x, double y, com.game.src.main.Game game) {
        this.x = x;
        this.y = y;
        this.game = game;

        try {
            img = ImageIO.read(getClass().getResource("/boss.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void tick() {

    }

    void render(Graphics g) {
        g.drawImage(img, (int)x, (int)y, null);
//		System.out.println("X = " + x + " Y = " + y);
    }

    double getX() {
        return x;
    }

    void setX(double x) {
        this.x = x;
    }

    double getY() {
        return y;
    }

    void setY(double y) {
        this.y = y;
    }


}
