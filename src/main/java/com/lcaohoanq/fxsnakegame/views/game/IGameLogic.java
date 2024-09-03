package com.lcaohoanq.fxsnakegame.views.game;

import com.lcaohoanq.fxsnakegame.views.game.apartment.Apartment;
import com.lcaohoanq.fxsnakegame.views.game.box.Box;
import com.lcaohoanq.fxsnakegame.views.game.campaign.Campaign;
import com.lcaohoanq.fxsnakegame.views.game.mill.Mill;
import com.lcaohoanq.fxsnakegame.views.game.nomaze.NoMaze;
import com.lcaohoanq.fxsnakegame.views.game.rails.Rails;
import com.lcaohoanq.fxsnakegame.views.game.tunnel.Tunnel;
import javax.swing.JFrame;

public interface IGameLogic {

    void checkCollision();

    void checkSelfCollision();

    void checkBoundaryCollision();

    void checkWallCollision();

    void locateApple();

    void locateBigApple();

    default void checkGameMode(JFrame currentFrame, String mode){
        if (mode.equals("Classic")) {
            currentFrame.add(new NoMaze()); // NoMaze is the default mode
        }
        if (mode.equals("NoMaze")) {
            currentFrame.add(new NoMaze());  // NoMaze is the default mode
        }
        if (mode.equals("Box")) {
            currentFrame.add(new Box());
        }
        if (mode.equals("Tunnel")) {
            currentFrame.add(new Tunnel());
        }
        if (mode.equals("Mill")) {
            currentFrame.add(new Mill());
        }
        if (mode.equals("Rails")) {
            currentFrame.add(new Rails());
        }
        if (mode.equals("Apartment")) {
            currentFrame.add(new Apartment());
        }
        if (mode.equals("Campaign")) {
            currentFrame.add(new Campaign());
        }
    };

}
