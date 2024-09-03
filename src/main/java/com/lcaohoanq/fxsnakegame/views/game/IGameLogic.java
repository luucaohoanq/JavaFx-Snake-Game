package com.lcaohoanq.fxsnakegame.views.game;

public interface IGameLogic {

    void checkCollision();

    void checkSelfCollision();

    void checkBoundaryCollision();

    void checkWallCollision();

    void locateApple();

    void locateBigApple();

}
