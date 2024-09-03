package com.lcaohoanq.fxsnakegame.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.lcaohoanq.fxsnakegame.views.login.SwingLoginView;
import com.lcaohoanq.fxsnakegame.views.menu.MenuView;
import com.lcaohoanq.fxsnakegame.views.game.GameMode;

public class PlayController implements ActionListener {
    public static MenuView menuView;
    private SwingLoginView loginView;
    private GameMode gameMode;
    private boolean isLoginView = false;
    private boolean isSnake = false;

    public PlayController(SwingLoginView loginView) {
        this.loginView = loginView;
        isLoginView = true;
    }

    public PlayController(GameMode gameMode) {
        this.gameMode = gameMode;
        isSnake = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isLoginView) {
            loginView.dispose();
            EventQueue.invokeLater(() -> {
                menuView = new MenuView();
                menuView.setVisible(true);
            });
        }
        if (isSnake) {
            gameMode.dispose();
            EventQueue.invokeLater(() -> {
                menuView = new MenuView();
                menuView.setVisible(true);
            });
        }
    }
}
