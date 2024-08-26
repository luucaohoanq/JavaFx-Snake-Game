package com.lcaohoanq.formhandling.constants;

import com.lcaohoanq.formhandling.views.base.MyFrame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ResourcePaths {
    // img
    public static final String URL_DOT = "/assets/img/dot.png";
    public static final String URL_HEAD = "/assets/img/head.png";
    public static final String URL_APPLE = "/assets/img/apple.png";
    public static final String URL_BIG_APPLE = "/assets/img/big_apple.png";
    public static final String URL_WALL = "/assets/img/wall.png";
    public static final String URL_KEY_ICON = "/assets/img/key.png";
    public static final String URL_SNAKE_LOGO = "/assets/img/snake.png";
    //sound
    public static final String URL_EATING2 = "/assets/sound/eating2.wav";
    public static final String URL_GAME_OVER = "/assets/sound/gameover.wav";
    public static final String URL_EATING = "/assets/sound/eating.wav";
    public static final String URL_INTRO = "/assets/sound/intro.wav";
    public static final String URL_BIG_APPLE_DIS = "/assets/sound/bigAppleDis.wav";
    public static final String URL_BIG_APPLE_APP = "/assets/sound/bigAppleApp.wav";


    public static void main(String[] args) {
        try{
            JLabel jLabel_Left_Icon = new JLabel(
                new ImageIcon(new ImageIcon(
                    Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource(ResourcePaths.URL_SNAKE_LOGO))).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
            if (jLabel_Left_Icon != null) {
                System.out.println("jLabel_Left_Icon is not null");
            }else{
                System.out.println("jLabel_Left_Icon is null");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
