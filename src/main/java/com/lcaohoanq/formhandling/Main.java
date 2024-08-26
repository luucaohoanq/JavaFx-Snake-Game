package com.lcaohoanq.formhandling;

import com.lcaohoanq.formhandling.utils.LogsUtils;
import com.lcaohoanq.formhandling.views.LoginView;
import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {

        //create logs folder if it does not exist
        LogsUtils.ensureLogsFolderExists();

        EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}
