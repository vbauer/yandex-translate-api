package com.github.vbauer.yta.model;

import org.immutables.value.Value.Immutable;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Vladislav Bauer
 */

@Immutable
public abstract class Languages implements Serializable {

    public abstract Set<Language> languages();

    public abstract Set<Direction> directions();

}
