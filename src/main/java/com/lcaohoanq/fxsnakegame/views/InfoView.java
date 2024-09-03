package com.lcaohoanq.fxsnakegame.views;

import com.lcaohoanq.fxsnakegame.views.utils.UIPrompts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoView implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UIPrompts.IS_ABOUT_ME();
    }

}
