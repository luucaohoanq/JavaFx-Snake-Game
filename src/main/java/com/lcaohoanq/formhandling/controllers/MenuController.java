package com.lcaohoanq.formhandling.controllers;

import com.lcaohoanq.formhandling.constants.ResourcePaths;
import com.lcaohoanq.formhandling.enums.Hover;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import com.lcaohoanq.formhandling.modules.sound.AudioHandler;
import com.lcaohoanq.formhandling.styles.UIHovers;
import com.lcaohoanq.formhandling.views.MenuView;
import com.lcaohoanq.formhandling.views.UIPrompts;
import com.lcaohoanq.formhandling.views.base.AppComponent;
import com.lcaohoanq.formhandling.views.game.Snake;

public class MenuController implements MouseListener, ActionListener {

    public static MenuView menuView;
    public static MenuView.MenuModern menuModern;
    private boolean isMenuModern = true;
    private final AudioHandler audioHandler;
    private UIHovers<MenuView> uiHovers;

    private final List<JButton> jButtonList;
//    private UIHovers<MenuView> uiHovers;

    public MenuController(MenuView menuView) {
        MenuController.menuView = menuView;
        this.audioHandler = new AudioHandler();
        this.jButtonList = Arrays.asList(
            menuView.jButton_Mode_Classic,
            menuView.jButton_Mode_Modern,
            menuView.jButton_Mode_Campaign);
        this.uiHovers = new UIHovers<>(menuView);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == menuView.jButton_Mode_Classic) {
            EventQueue.invokeLater(() -> {
                menuView.dispose();
                new Snake("Classic").startGame();
            });
        }
        if (e.getSource() == menuView.jButton_Mode_Modern) {
            EventQueue.invokeLater(() -> {

                if (isMenuModern) {
                    menuModern = menuView.new MenuModern();
                    isMenuModern = true;
//                    menuView.dispose();
                    menuModern.setVisible(true);
                } else {
//                    menuView.dispose();
                    isMenuModern = false;
                }
            });
        }
        if (e.getSource() == menuView.jButton_Mode_Campaign) {
            EventQueue.invokeLater(() -> {
//                menuView.dispose();
//                new Snake("Campaign").startGame();

                prepareUnsupportFeature();
            });
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (menuView.isActive()) {
            jButtonList.stream()
                .filter(button -> e.getSource() == button)
                .forEach(button -> {
                    if (menuView.getStatusToggle()) {
                        uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "dark", button);
                    } else {
                        uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "light", button);
                    }
                });
        }
    }


    @Override
    public void mouseExited(MouseEvent e) {
        if (menuView.isActive()) {
            jButtonList.stream()
                .filter(button -> e.getSource() == button)
                .forEach(button -> {
                    if (menuView.getStatusToggle()) {
                        uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "dark", button);
                    } else {
                        uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "light", button);
                    }
                });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Off")) {
            System.out.println("user click Off sound");
            menuView.setAudio(false);
        } else if (e.getActionCommand().equals("On")) {
            menuView.setAudio(Hover.ENABLE.isStatus());
        }
    }

    private void prepareUnsupportFeature() {
        InputStream unsupported = getClass().getResourceAsStream(ResourcePaths.URL_EATING);
        audioHandler.playAudio(unsupported);
        UIPrompts.IS_NOT_SUPPORT();
    }

    public static class MenuModernController extends AppComponent implements MouseListener {

        private final MenuView.MenuModern menuModern;
        private final AudioHandler audioHandler;
        private UIHovers<MenuView.MenuModern> uiHovers;

        public MenuModernController(MenuView.MenuModern menuModern) {
            this.menuModern = menuModern;
            this.audioHandler = new AudioHandler();
            this.uiHovers = new UIHovers<>(menuModern);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == menuModern.getJButton_NoMaze()) {
                EventQueue.invokeLater(() -> {
                    menuView.dispose();
                    new Snake("NoMaze").startGame();
                });
            }
            if (e.getSource() == menuModern.getJButton_Box()) {
                EventQueue.invokeLater(() -> {
                    menuView.dispose();
                    new Snake("Box").startGame();
                });
            }
            if (e.getSource() == menuModern.getJButton_Tunnel()) {
                EventQueue.invokeLater(() -> {
                    menuView.dispose();
                    new Snake("Tunnel").startGame();
                });
            }
            if (e.getSource() == menuModern.getJButton_Mill()) {
                EventQueue.invokeLater(() -> {
                    menuView.dispose();
                    new Snake("Mill").startGame();
                });
            }
            if (e.getSource() == menuModern.getJButton_Rails()) {
                EventQueue.invokeLater(() -> {
                    menuView.dispose();
                    new Snake("Rails").startGame();
                });
            }
            if (e.getSource() == menuModern.getJButton_Apartment()) {
                EventQueue.invokeLater(() -> {
                    menuView.dispose();
                    new Snake("Apartment").startGame();
                });
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (menuModern.getStatusToggle()) {
                if (e.getSource() == menuModern.getJButton_NoMaze()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "dark", menuModern.getJButton_NoMaze());
                }
                if (e.getSource() == menuModern.getJButton_Box()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "dark", menuModern.getJButton_Box());
                }
                if (e.getSource() == menuModern.getJButton_Tunnel()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "dark", menuModern.getJButton_Tunnel());
                }
                if (e.getSource() == menuModern.getJButton_Mill()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "dark", menuModern.getJButton_Mill());
                }
                if (e.getSource() == menuModern.getJButton_Rails()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "dark", menuModern.getJButton_Rails());
                }
                if (e.getSource() == menuModern.getJButton_Apartment()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "dark", menuModern.getJButton_Apartment());
                }
            } else {
                if (e.getSource() == menuModern.getJButton_NoMaze()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "light", menuModern.getJButton_NoMaze());
                }
                if (e.getSource() == menuModern.getJButton_Box()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "light", menuModern.getJButton_Box());
                }
                if (e.getSource() == menuModern.getJButton_Tunnel()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "light", menuModern.getJButton_Tunnel());
                }
                if (e.getSource() == menuModern.getJButton_Mill()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "light", menuModern.getJButton_Mill());
                }
                if (e.getSource() == menuModern.getJButton_Rails()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "light", menuModern.getJButton_Rails());
                }
                if (e.getSource() == menuModern.getJButton_Apartment()) {
                    uiHovers.setHoverButton(Hover.ENABLE.isStatus(), "light", menuModern.getJButton_Apartment());
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (menuModern.getStatusToggle()) {
                if (e.getSource() == menuModern.getJButton_NoMaze()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "dark", menuModern.getJButton_NoMaze());
                }
                if (e.getSource() == menuModern.getJButton_Box()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "dark", menuModern.getJButton_Box());
                }
                if (e.getSource() == menuModern.getJButton_Tunnel()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "dark", menuModern.getJButton_Tunnel());
                }
                if (e.getSource() == menuModern.getJButton_Mill()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "dark", menuModern.getJButton_Mill());
                }
                if (e.getSource() == menuModern.getJButton_Rails()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "dark", menuModern.getJButton_Rails());
                }
                if (e.getSource() == menuModern.getJButton_Apartment()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "dark", menuModern.getJButton_Apartment());
                }
            } else {
                if (e.getSource() == menuModern.getJButton_NoMaze()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "light", menuModern.getJButton_NoMaze());
                }
                if (e.getSource() == menuModern.getJButton_Box()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "light", menuModern.getJButton_Box());
                }
                if (e.getSource() == menuModern.getJButton_Tunnel()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "light", menuModern.getJButton_Tunnel());
                }
                if (e.getSource() == menuModern.getJButton_Mill()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "light", menuModern.getJButton_Mill());
                }
                if (e.getSource() == menuModern.getJButton_Rails()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "light", menuModern.getJButton_Rails());
                }
                if (e.getSource() == menuModern.getJButton_Apartment()) {
                    uiHovers.setHoverButton(Hover.DISABLE.isStatus(), "light", menuModern.getJButton_Apartment());
                }
            }
        }

        private void prepareUnsupportFeature() {
            InputStream unsupported = getClass().getResourceAsStream(ResourcePaths.URL_EATING);
            audioHandler.playAudio(unsupported);
            UIPrompts.IS_NOT_SUPPORT();
        }

        @Override
        public void initComponents() {

        }

        @Override
        public void doAction() {

        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MenuView menuView = new MenuView();
            MenuController menuController = new MenuController(menuView);
            menuView.setVisible(true);
        });
    }

}
