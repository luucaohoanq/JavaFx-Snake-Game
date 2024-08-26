package com.lcaohoanq.formhandling.constants;

import com.lcaohoanq.formhandling.views.UIPrompts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UIPrompts.IS_ABOUT_ME();
    }

}
