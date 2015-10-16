package com.github.vbauer.yta.model;

import org.immutables.value.Value.Immutable;

/**
 * @author Vladislav Bauer
 */

@Immutable
public abstract class Translation {

    public abstract Direction direction();

    public abstract String text();


    @Override
    public String toString() {
        return text();
    }

}
