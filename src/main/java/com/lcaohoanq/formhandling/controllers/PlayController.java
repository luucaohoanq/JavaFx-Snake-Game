package com.lcaohoanq.formhandling.controllers;

import com.lcaohoanq.formhandling.views.LoginView;
import com.lcaohoanq.formhandling.views.MenuView;
import com.lcaohoanq.formhandling.views.game.Snake;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayController implements ActionListener {
    public static MenuView menuView;
    private LoginView loginView;
    private Snake snake;
    private boolean isLoginView = false;
    private boolean isSnake = false;

    public PlayController(LoginView loginView) {
        this.loginView = loginView;
        isLoginView = true;
    }

    public PlayController(Snake snake) {
        this.snake = snake;
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
            snake.dispose();
            EventQueue.invokeLater(() -> {
                menuView = new MenuView();
                menuView.setVisible(true);
            });
        }
    }
}
