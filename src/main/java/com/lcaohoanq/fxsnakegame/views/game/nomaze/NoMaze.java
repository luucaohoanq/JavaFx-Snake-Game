package com.lcaohoanq.fxsnakegame.views.game.nomaze;

import com.lcaohoanq.fxsnakegame.constants.ResourcePaths;
import java.io.InputStream;
import com.lcaohoanq.fxsnakegame.styles.UISizes;
import com.lcaohoanq.fxsnakegame.views.game.board.BoardView;

public class NoMaze extends BoardView {

    public NoMaze() {
        super();
    }

    @Override
    public void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
                break;
            }
        }

        if (y[0] >= UISizes.HEIGHT_BOARD - 50) {
            y[0] = 0;
        }

        if (y[0] < 0) {
            y[0] = UISizes.HEIGHT_BOARD - 50 - DOT_SIZE;
        }

        if (x[0] >= UISizes.WIDTH_BOARD) {
            x[0] = 0;
        }

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
    public void checkSelfCollision() {

    }

    @Override
    public void checkBoundaryCollision() {

    }

    @Override
    public void checkWallCollision() {

    }

    @Override
    public void locateApple() {
        if (apple_count % 5 == 0 && apple_count != 0) {
            locateBigApple();
        } else {
            bigApple_x = -100;
            int r = (int) (Math.random() * RAND_POS);
            apple_x = ((r * DOT_SIZE));

            bigApple_y = -100;
            r = (int) (Math.random() * RAND_POS);
            apple_y = ((r * DOT_SIZE) + DOT_SIZE);
        }
    }

    @Override
    public void locateBigApple() {
        if (isOnSound()) {
//            audioHandler.setAudio(audioHandler.formatAudioPath(getClass().getResource(Paths.URL_BIG_APPLE_APP).getPath()));
            InputStream inputStream = getClass().getResourceAsStream(ResourcePaths.URL_BIG_APPLE_APP);
            audioUtils.playAudio(inputStream);
        }
        int r = (int) (Math.random() * RAND_POS);
        bigApple_x = ((r * DOT_SIZE));
        apple_x = -100;

        r = (int) (Math.random() * RAND_POS);
        bigApple_y = ((r * DOT_SIZE));
        apple_y = -100;
        setBigAppleTime();
        renderProgressBar();
    }
}
