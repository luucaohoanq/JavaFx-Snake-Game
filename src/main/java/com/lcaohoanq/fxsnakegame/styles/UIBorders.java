package com.lcaohoanq.fxsnakegame.styles;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class UIBorders {

    // Borders for containers
    public static final EmptyBorder CONTAINER = new EmptyBorder(0, 30, 0, 30);
    public static final EmptyBorder CONTAINER_MENU = new EmptyBorder(30, 30, 30, 30);
    // Borders for line inputs
    public static final Border LINE_MENU_BAR = BorderFactory.createLineBorder(Color.WHITE, 1);

    // My frame
    public static final EmptyBorder TITLE = new EmptyBorder(20, 0, 0, 0);
    public static final EmptyBorder DATA_FIELD = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder MIDDLE = new EmptyBorder(10, 0, 10, 0);
    public static final EmptyBorder MID_LABEL = new EmptyBorder(0, 0, 10, 0);
    public static final EmptyBorder BUTTON = new EmptyBorder(30, 0, 20, 0);
    public static final EmptyBorder MID_FIELD = new EmptyBorder(10, 20, 10, 20);
    public static final EmptyBorder BOTTOM_SCORE_PROGRESS_BAR = new EmptyBorder(0, 10, 20, 10);
    public static final EmptyBorder GAME_OVER_ELEMENT = new EmptyBorder(150, 30, 170, 30);

    public static Border createBorder(String type, int top, int left, int bottom, int right,
        Color color) {
        return switch (type.toLowerCase()) {
            case "empty" -> new EmptyBorder(top, left, bottom, right);
            case "line" ->
                // Assuming 'left' is used as the thickness for line borders for simplicity
                BorderFactory.createLineBorder(color, left);
            default -> throw new IllegalArgumentException("Unsupported border type: " + type);
        };
    }

}

