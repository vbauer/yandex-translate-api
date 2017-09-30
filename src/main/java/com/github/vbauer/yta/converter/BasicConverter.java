package com.github.vbauer.yta.converter;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Basic converter to transform type I to O.
 *
 * @param <I> input type
 * @param <O> output type
 * @author Vladislav Bauer
 */

@ThreadSafe
public interface BasicConverter<I, O> {

    @Nonnull
    O convert(@Nonnull I input);

}
