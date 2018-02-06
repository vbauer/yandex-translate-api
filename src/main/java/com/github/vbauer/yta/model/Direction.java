package com.github.vbauer.yta.model;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Optional;

/**
 * Model which represents direction of translation.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
@Immutable
public abstract class Direction implements Serializable {

    public static final String SEPARATOR = "-";


    /**
     * Get source/origin language.
     *
     * @return source language
     */
    @Nonnull
    @Parameter(order = 0)
    public abstract Optional<Language> source();

    /**
     * Get target/destination language.
     *
     * @return target language
     */
    @Nonnull
    @Parameter(order = 1)
    public abstract Language target();


    /**
     * A factory method to create direction object using source and target languages.
     *
     * @param source source language
     * @param target target language
     * @return direction (from source to target)
     */
    @Nonnull
    public static Direction of(@Nullable final Language source, @Nonnull final Language target) {
        return ImmutableDirection.of(Optional.ofNullable(source), target);
    }

    /**
     * A factory method to create direction object using only target language.
     * Source language will be null/empty (and will be detected automatically during translation).
     *
     * @param target target language
     * @return direction (from something to target)
     */
    @Nonnull
    public static Direction of(@Nonnull final Language target) {
        return of(null, target);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final String prefix = source()
            .map(language -> language.toString() + SEPARATOR)
            .orElseGet(String::new);

        return prefix + target().toString();
    }

}
