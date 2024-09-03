package com.lcaohoanq.fxsnakegame.controllers;

import com.lcaohoanq.fxsnakegame.views.utils.Toggle;

public interface ToggleHandler {
    Toggle toggleButton = new Toggle();

    void changeColorBaseOnToggle();

    default boolean getStatusToggle() {
        return toggleButton.isSelected();
    }
}
