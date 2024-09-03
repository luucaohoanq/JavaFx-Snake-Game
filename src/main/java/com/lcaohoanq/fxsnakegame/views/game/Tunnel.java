package com.lcaohoanq.fxsnakegame.views.game;

import com.lcaohoanq.fxsnakegame.constants.ResourcePaths;
import com.lcaohoanq.fxsnakegame.styles.UISizes;
import com.lcaohoanq.fxsnakegame.views.base.BoardView;
import java.awt.Graphics;
import java.io.InputStream;
import javax.swing.JFrame;

public class Tunnel extends BoardView {
    protected int wallThickness = 20;

    public Tunnel() {
        super();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Tunnel());
        frame.pack();
        frame.setSize(UISizes.WIDTH_BOARD, UISizes.HEIGHT_BOARD);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw the 2 left horizontal walls
        for (int i = 0; i < 100; i += 20) {
            g.drawImage(uiImages.getWall(), i, 0, this);
            g.drawImage(uiImages.getWall(), i, UISizes.HEIGHT_BOARD - 70, this);
        }
        //draw the 2 right horizontal walls
        for (int i = 400; i < UISizes.WIDTH_BOARD; i += 20) {
            g.drawImage(uiImages.getWall(), i, 0, this);
            g.drawImage(uiImages.getWall(), i, UISizes.HEIGHT_BOARD - 70, this);
        }
        //draw the 2 left vertical walls
        for (int i = 0; i < 100; i += 20) {
            g.drawImage(uiImages.getWall(), 0, i, this);
            g.drawImage(uiImages.getWall(), 0, UISizes.HEIGHT_BOARD - 70 - i, this);
        }
        //draw the 2 right vertical walls
        for (int i = 0; i < 100; i += 20) {
            g.drawImage(uiImages.getWall(), UISizes.WIDTH_BOARD - 20, i, this);
            g.drawImage(uiImages.getWall(), UISizes.WIDTH_BOARD - 20, UISizes.HEIGHT_BOARD - 70 - i, this);
        }
        //draw the 2 middle horizontal walls
        for (int i = 100; i < 400; i += 20) {
            g.drawImage(uiImages.getWall(), i, 205, this);
            g.drawImage(uiImages.getWall(), i, UISizes.HEIGHT_BOARD - 50 - 100 - 105, this);
        }
    }

    @Override
    public void checkCollision() {
        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
                break;
            }
        }

        //check if the snake hit the first middle horizontal walls (done)
        if (y[0] >= 205 && y[0] <= 225 && x[0] >= 100 && x[0] <= 390) {
            inGame = false;
        }

        //check if the snake hit the second middle horizontal walls (done)
        if(y[0] >= UISizes.HEIGHT_BOARD - 50 - 100 - 105 && y[0] <= UISizes.HEIGHT_BOARD - 50 - 100 - 85 && x[0] >= 100 && x[0] <= 390){
            inGame = false;
        }

        //check if the snake hit the top left vertical walls (done)
        if (x[0] >= 0 && x[0] <= 20 && y[0] >= 0 && y[0] <= 90) {
            inGame = false;
        }

        //check if the snake hit the bottom left vertical walls
        if (x[0] >= 0 && x[0] <= 20 && y[0] >= UISizes.HEIGHT_BOARD - 50 - 100 && y[0] <= UISizes.HEIGHT_BOARD - 50) {
            inGame = false;
        }

        //check if the snake hit the top right vertical walls (done)
        if (x[0] >= UISizes.WIDTH_BOARD - 20 && x[0] <= UISizes.WIDTH_BOARD && y[0] >= 0 && y[0] <= 90) {
            inGame = false;
        }

        //check if the snake hit the bottom right vertical walls
        if (x[0] >= UISizes.WIDTH_BOARD - 20 && x[0] <= UISizes.WIDTH_BOARD && y[0] >= UISizes.HEIGHT_BOARD - 50 - 100 && y[0] <= UISizes.HEIGHT_BOARD - 70) {
            inGame = false;
        }

        //check if the snake hit the top left horizontal walls (done)
        if (y[0] >= 0 && y[0] <= 20 && x[0] >= 0 && x[0] <= 90) {
            inGame = false;
        }

        //check if the snake hit the bottom left horizontal walls
        if (y[0] >= UISizes.HEIGHT_BOARD - 70 && y[0] <= UISizes.HEIGHT_BOARD - 70 && x[0] >= 0 && x[0] <= 90) {
            inGame = false;
        }

        //check if the snake hit the top right horizontal walls
        if (y[0] >= 0 && y[0] <= 20 && x[0] >= UISizes.WIDTH_BOARD - 100 && x[0] <= UISizes.WIDTH_BOARD) {
            inGame = false;
        }

        //check if the snake hit the bottom right horizontal walls
        if (y[0] >= UISizes.HEIGHT_BOARD - 70 && y[0] <= UISizes.HEIGHT_BOARD - 50 && x[0] >= UISizes.WIDTH_BOARD - 100 && x[0] <= UISizes.WIDTH_BOARD) {
            inGame = false;
        }

        // snake go through the wall south
        if (y[0] >= UISizes.HEIGHT_BOARD - 50) {
            y[0] = 0;
        }

        // snake go through the wall north
        if (y[0] < 0 && x[0] >= 100 && x[0] <= UISizes.WIDTH_BOARD - 100) {
            y[0] = UISizes.HEIGHT_BOARD - 50 - DOT_SIZE;
        }

        // snake go through the wall east
        if (x[0] >= UISizes.WIDTH_BOARD && y[0] >= 100 && y[0] <= UISizes.HEIGHT_BOARD - 100) {
            x[0] = 0;
        }

        // snake go through the wall west
        if (x[0] < 0) {
            x[0] = UISizes.WIDTH_BOARD - DOT_SIZE;
        }

        if (!inGame) {
            if (isOnSound()) {
                InputStream inputStream = getClass().getResourceAsStream(ResourcePaths.URL_GAME_OVER);
                audioUtils.playAudio(inputStream);
            }
            timer.stop();
        }
    }

    @Override
    public void locateApple() {
        if (apple_count % 5 == 0 && apple_count != 0) {
            locateBigApple();
        } else {
            bigApple_x = -100;
            int r = (int) (Math.random() * (RAND_POS - 2 * wallThickness));
            apple_x = ((r + wallThickness) * DOT_SIZE);

            bigApple_y = -100;
            r = (int) (Math.random() * (RAND_POS - 2 * wallThickness));
            apple_y = ((r + wallThickness) * DOT_SIZE);
        }
    }

    @Override
    public void locateBigApple() {
        if (isOnSound()) {
            InputStream inputStream = getClass().getResourceAsStream(ResourcePaths.URL_BIG_APPLE_APP);
            audioUtils.playAudio(inputStream);
        }
        int r = (int) (Math.random() * (RAND_POS - 2 * wallThickness));
        bigApple_x = ((r + wallThickness) * DOT_SIZE);
        apple_x = -100;

        r = (int) (Math.random() * (RAND_POS - 2 * wallThickness));
        bigApple_y = ((r + wallThickness) * DOT_SIZE);
        apple_y = -100;
        setBigAppleTime();
        renderProgressBar();
    }
}
