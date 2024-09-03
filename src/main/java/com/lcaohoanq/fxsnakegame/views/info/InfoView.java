package com.lcaohoanq.fxsnakegame.views.info;

import com.lcaohoanq.fxsnakegame.views.utils.AppAlert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoView implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        AppAlert.IS_ABOUT_ME();
    }

}
