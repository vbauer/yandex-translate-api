package com.github.vbauer.yta.model;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author Vladislav Bauer
 */

@Immutable
public abstract class Direction implements Serializable {

    public static final String SEPARATOR = "-";


    @Parameter(order = 0)
    public abstract Optional<Language> source();

    @Parameter(order = 1)
    public abstract Language target();


    public static Direction of(final Language source, final Language target) {
        return ImmutableDirection.of(Optional.ofNullable(source), target);
    }

    public static Direction of(final Language target) {
        return of(null, target);
    }


    @Override
    public String toString() {
        final String prefix = source()
            .map(language -> language.toString() + SEPARATOR)
            .orElseGet(String::new);

        return  prefix + target().toString();
    }

}
