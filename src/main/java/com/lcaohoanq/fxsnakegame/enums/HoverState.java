package com.lcaohoanq.fxsnakegame.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HoverState {

    ENABLE(true),
    DISABLE(false);

    private final boolean status;

}
