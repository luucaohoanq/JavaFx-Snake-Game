package com.lcaohoanq.formhandling.styles;

import com.lcaohoanq.formhandling.constants.ResourcePaths;
import com.lcaohoanq.formhandling.views.base.MyFrame;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public class UIImages {
    public static final URL iconURL = MyFrame.class.getResource(ResourcePaths.URL_KEY_ICON);
    public static final Image icon = Toolkit.getDefaultToolkit().createImage(iconURL);

    public static final URL snakeURL = MyFrame.class.getResource(ResourcePaths.URL_SNAKE_LOGO);
    public static final Image logo = Toolkit.getDefaultToolkit().getImage(snakeURL);
    public static final ImageIcon logoIcon = new ImageIcon(logo);

    public static void main(String[] args) {
        try{
            ImageIcon jLabel_Left_Icon = new ImageIcon(new ImageIcon(icon).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
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
