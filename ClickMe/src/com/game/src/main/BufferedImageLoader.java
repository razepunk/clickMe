package com.game.src.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


class BufferedImageLoader {

    BufferedImage loadImage(String path) throws IOException {
        // TODO Auto-generated method stub
        return ImageIO.read(getClass().getResource(path));

    }

}
