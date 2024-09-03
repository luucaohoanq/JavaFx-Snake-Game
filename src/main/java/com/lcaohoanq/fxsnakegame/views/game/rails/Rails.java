package com.lcaohoanq.fxsnakegame.views.game.rails;

import com.lcaohoanq.fxsnakegame.constants.ResourcePaths;
import com.lcaohoanq.fxsnakegame.styles.UISizes;
import com.lcaohoanq.fxsnakegame.views.game.board.BoardView;
import java.awt.Graphics;
import java.io.InputStream;

public class Rails extends BoardView {

    private final int wallThickness = 20;

    public Rails() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw the top and bottom horizontal walls
        for (int i = 0; i < UISizes.WIDTH_BOARD; i += 20) {
            g.drawImage(uiImages.getWall(), i, 0, this);
            g.drawImage(uiImages.getWall(), i, UISizes.HEIGHT_BOARD - 70, this);
        }
        //draw the 2 left vertical walls from y = 0 to y = 200 and from y = 300 to y = 480
        for (int i = 0; i < 200; i += 20) {
            g.drawImage(uiImages.getWall(), 0, i, this);
            g.drawImage(uiImages.getWall(), 0, UISizes.HEIGHT_BOARD - 70 - i, this);
        }
        //draw the 2 right vertical walls from
        for (int i = 0; i < 200; i += 20) {
            g.drawImage(uiImages.getWall(), UISizes.WIDTH_BOARD - 20, i, this);
            g.drawImage(uiImages.getWall(), UISizes.WIDTH_BOARD - 20, UISizes.HEIGHT_BOARD - 70 - i, this);
        }
        //draw the 2 middle horizontal walls
        for (int i = 100; i < 400; i += 20) {
            g.drawImage(uiImages.getWall(), i, 140, this);
            g.drawImage(uiImages.getWall(), i, UISizes.HEIGHT_BOARD - 50 - 160, this);
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

        // snake hit the walls north
        if (y[0] <= 20) {
            inGame = false;
        }

        // snake hit the walls south
        if(y[0] >= UISizes.HEIGHT_BOARD - 70){
            inGame = false;
        }

        // snake hit the top left vertical wall
        if (x[0] <= 20 && y[0] <= 200) {
            inGame = false;
        }

        // snake hit the bottom left vertical wall
        if (x[0] <= 20 && y[0] >= UISizes.HEIGHT_BOARD - 50 - 200) {
            inGame = false;
        }

        // snake hit the top right vertical wall
        if (x[0] >= UISizes.WIDTH_BOARD - 20 && y[0] <= 200) {
            inGame = false;
        }

        // snake hit the bottom right vertical wall
        if (x[0] >= UISizes.WIDTH_BOARD - 20 && y[0] >= UISizes.HEIGHT_BOARD - 50 - 200) {
            inGame = false;
        }

        // snake hit the first horizontal wall length 400 at x = 100, y = 140, each block is 20x20
        if (y[0] >= 140 && y[0] <= 160 && x[0] >= 100 && x[0] <= 390) {
            inGame = false;
        }

        // snake hit the second horizontal wall length 400 at x = 100, y = 340, each block is 20x20
        if (y[0] >= UISizes.HEIGHT_BOARD - 50 - 160 && y[0] <= UISizes.HEIGHT_BOARD - 50 - 140 && x[0] >= 100 && x[0] <= 390) {
            inGame = false;
        }

        // snake can go through the walls east
        if (x[0] >= UISizes.WIDTH_BOARD && y[0] >= 200 && y[0] <= UISizes.HEIGHT_BOARD - 50 - 200) {
            x[0] = 0;
        }

        // snake can go through the walls west
        if (x[0] < 0 && y[0] >= 200 && y[0] <= UISizes.HEIGHT_BOARD - 50 - 200) {
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
