package com.lcaohoanq.fxsnakegame.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HoverElement {

    ENABLE(true),
    DISABLE(false);

    private final boolean status;

}
