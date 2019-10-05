package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class HighScoreMenu {

    private Game game;

    private Rectangle retryButton = new Rectangle(Game.WIDTH / 2 + 120, 250, 100, 50);
    private Rectangle quitButton = new Rectangle(Game.WIDTH / 2 + 120, 350, 100, 50);

    HighScoreMenu(Game game) {
        this.game = game;
    }

    void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt0);
        g.setColor(Color.BLACK);
        g.drawString("Your Score is", Game.WIDTH / 2 + 70, 100);

        Font fnt1 = new Font("arial", Font.BOLD, 80);
        g.setFont(fnt1);
        g.setColor(Color.CYAN);
        if (Game.SCORE < 10) {
            g.drawString(Integer.toString(Game.SCORE), Game.WIDTH / 2 + 140, 200);
        } else if (Game.SCORE >= 10) {
            g.drawString(Integer.toString(Game.SCORE), Game.WIDTH / 2 + 125, 200);
        }

        Font fnt2 = new Font("arial", Font.BOLD, 25);
        g.setFont(fnt2);
        g.setColor(Color.BLACK);
        g.drawString("RETRY", retryButton.x + 8, retryButton.y + 35);
        g2d.draw(retryButton);
        g.drawString("QUIT", quitButton.x + 20, quitButton.y + 35);
        g2d.draw(quitButton);
    }

}