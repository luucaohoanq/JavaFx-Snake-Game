package com.lcaohoanq.fxsnakegame.views.game;

import com.lcaohoanq.fxsnakegame.constants.ResourcePaths;
import com.lcaohoanq.fxsnakegame.styles.UISizes;
import com.lcaohoanq.fxsnakegame.views.base.Board;
import java.awt.Graphics;
import java.io.InputStream;

public class Box extends Board {
    protected int wallThickness = 20;

    public Box() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < UISizes.WIDTH_BOARD; i += 20) {
            g.drawImage(uiImages.getWall(), i, 0, this);
            g.drawImage(uiImages.getWall(), i, UISizes.HEIGHT_BOARD - 70, this);
        }
        for (int i = 0; i < UISizes.HEIGHT_BOARD - 70; i += 20) {
            g.drawImage(uiImages.getWall(), 0, i, this);
            g.drawImage(uiImages.getWall(), UISizes.WIDTH_BOARD - 20, i, this);
        }
    }

    @Override
    protected void checkCollision() {
        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
                break;
            }
        }

        if (y[0] >= UISizes.HEIGHT_BOARD - 70) {
            inGame = false;
        }

        if (y[0] < 20) {
            inGame = false;
        }

        if (x[0] >= UISizes.WIDTH_BOARD) {
            inGame = false;
        }

        if (x[0] < 20) {
            inGame = false;
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
    protected void locateApple() {
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
    protected void locateBigApple() {
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
