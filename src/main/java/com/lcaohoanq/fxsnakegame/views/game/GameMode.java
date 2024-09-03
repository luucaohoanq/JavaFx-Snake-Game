package com.lcaohoanq.fxsnakegame.views.game;

import com.lcaohoanq.fxsnakegame.controllers.MenuController;
import com.lcaohoanq.fxsnakegame.controllers.PlayController;
import com.lcaohoanq.fxsnakegame.views.game.apartment.Apartment;
import com.lcaohoanq.fxsnakegame.views.game.box.Box;
import com.lcaohoanq.fxsnakegame.views.game.campaign.Campaign;
import com.lcaohoanq.fxsnakegame.views.game.mill.Mill;
import com.lcaohoanq.fxsnakegame.views.game.nomaze.NoMaze;
import com.lcaohoanq.fxsnakegame.views.game.rails.Rails;
import com.lcaohoanq.fxsnakegame.views.game.tunnel.Tunnel;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.lcaohoanq.fxsnakegame.styles.UIBorders;
import com.lcaohoanq.fxsnakegame.styles.UIImages;

public class GameMode extends JFrame {
    private final JMenuBar jMenuBar = new JMenuBar();
    private final JMenu jMenu = new JMenu("HELP");
    private final JMenuItem jMenuItem_Back_To_Main_Menu = new JMenuItem("Back to main menu");

    public GameMode(String mode) {
        initMenu();
        initUI(mode);
    }

    private void initUI(String mode) {
        checkMode(mode);
        setResizable(false);
        pack();
        setTitle("Snake");
        setIconImage(UIImages.icon);
        setJMenuBar(jMenuBar);
        MenuController.menuView.dispose();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initMenu() {
        jMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        jMenuBar.setBorder(UIBorders.LINE_MENU_BAR);
        jMenuBar.add(jMenu);
        jMenu.add(jMenuItem_Back_To_Main_Menu);
        jMenuItem_Back_To_Main_Menu.addActionListener(new PlayController(this));
        this.setJMenuBar(jMenuBar);
    }

    private void checkMode(String mode) {
        if (mode.equals("Classic")) {
            add(new NoMaze()); // NoMaze is the default mode
        }
        if (mode.equals("NoMaze")) {
            add(new NoMaze());  // NoMaze is the default mode
        }
        if (mode.equals("Box")) {
            add(new Box());
        }
        if (mode.equals("Tunnel")) {
            add(new Tunnel());
        }
        if (mode.equals("Mill")) {
            add(new Mill());
        }
        if (mode.equals("Rails")) {
            add(new Rails());
        }
        if (mode.equals("Apartment")) {
            add(new Apartment());
        }
        if (mode.equals("Campaign")) {
            add(new Campaign());
        }
    }

    public void startGame() {
        setVisible(true);
    }

    public void stopGame() {
        dispose();
    }

}
